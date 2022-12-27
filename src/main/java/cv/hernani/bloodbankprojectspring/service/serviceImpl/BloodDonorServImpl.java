package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.BloodDonorCreateDto;
import cv.hernani.bloodbankprojectspring.dtos.BloodDonorDto;
import cv.hernani.bloodbankprojectspring.models.BloodDonorModel;
import cv.hernani.bloodbankprojectspring.models.EmployeeModel;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.repositories.BloodDonorRepository;
import cv.hernani.bloodbankprojectspring.repositories.EmployeeRepository;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;
import cv.hernani.bloodbankprojectspring.service.service.BloodDonorService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.Helper;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class BloodDonorServImpl implements BloodDonorService {

    final BloodDonorRepository bloodDonorRepository;
    final PersonRepository personRepository;
    final EmployeeRepository employeeRepository;  

    public BloodDonorServImpl(BloodDonorRepository bloodDonorRepository,
                              PersonRepository personRepository,
                              EmployeeRepository employeeRepository) {
        this.bloodDonorRepository = bloodDonorRepository;
        this.personRepository = personRepository;
        this.employeeRepository = employeeRepository;
    }    

    @Override
    public APIResponse createBloodDonor(BloodDonorCreateDto bloodDonorCreateDto,UUID idEmployee, UUID idPerson) {
        Optional<PersonModel> personModelOptional = personRepository.findById(idPerson);
        if (!personModelOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Esta pessoa não existe na BD!"))
                    .build();
        }

        Optional<BloodDonorModel> bloodDonorOptional = bloodDonorRepository.findByIdPerson(personModelOptional.get());
        if (bloodDonorOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Este doador já existe na BD!")).build();
        }

        Optional<EmployeeModel> employeeModelOptional = employeeRepository.findById(idEmployee);
        if (!employeeModelOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Este funcionário não existe na BD")) .build();
        }

        var bloodDonorModel = new BloodDonorModel();
        boolean personStatus = true;

        if (!personStatus) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Esta pessoa não esta apta para ser doador!")).build();
                        
        } else {
        try {
            BeanUtils.copyProperties(bloodDonorCreateDto,bloodDonorModel);
            bloodDonorModel.setIdPerson(personModelOptional.get());
            bloodDonorModel.setWhoInserted(bloodDonorCreateDto.getWhoInserted());
            bloodDonorModel.setWhoUpdated(bloodDonorCreateDto.getWhoUpdated());
            String identfNumber = Helper.identfNumberGenerator();
            bloodDonorModel.setIdentifNumber(identfNumber);
            bloodDonorRepository.save(bloodDonorModel);
            
            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }
    }
    }

    @Override
    public APIResponse updtBloodDonor(UUID idDonner,UUID idEmpl, BloodDonorDto bloodDonorDto) {
        Optional<BloodDonorModel> bloodDonorOptional = bloodDonorRepository.findById(idDonner);
        if (!bloodDonorOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Doador nao existe na BD!")).build();
        }
        var bloodCollectionModel = new BloodDonorModel();

        try {
            BeanUtils.copyProperties(bloodDonorDto, bloodCollectionModel);
            bloodCollectionModel.setId(bloodDonorOptional.get().getId());
            bloodCollectionModel.setIdPerson(bloodDonorOptional.get().getIdPerson());
            bloodCollectionModel.setWhoUpdated(bloodDonorOptional.get().getWhoUpdated());
            bloodDonorRepository.save(bloodCollectionModel);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getAllBloodDonor() {
        List<BloodDonorModel> getAllBloodDonor = bloodDonorRepository.findAll();

        try {
            return APIResponse.builder().status(true)
                    .message(MessageState.SUCESSO)
                    .details(Arrays.asList(getAllBloodDonor)).build();
        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getBloodDonnerBy(String identifNumber) {

        try {
            Optional<BloodDonorModel> getBloodDonnerOpt = bloodDonorRepository.findByIdentifNumber(identifNumber);

            if (!getBloodDonnerOpt.isPresent()) {
                return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                        .details(Arrays.asList("ERRO: Este numero de doador não existe!")).build();
            } else {
                return APIResponse.builder().status(true).message(MessageState.SUCESSO)
                        .details(Arrays.asList(getBloodDonnerOpt))
                        .build();
            }

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage()))
                    .build();
        }

    }

    @Override
    public APIResponse getBloodDonorById(UUID id) {
        if (!bloodDonorRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Domain dont exists on DB!"))
                    .build();
        }
        Optional<BloodDonorModel> bloodDonorModel = bloodDonorRepository.findById(id);
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO)
                    .details(Arrays.asList(bloodDonorModel)).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage()))
                    .build();
        }
    }

    @Override
    public APIResponse delBloodDonor(UUID id) {
        if (!bloodDonorRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Domain dont exists on DB!"))
                    .build();
        }
        try {
            bloodDonorRepository.deleteById(id);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse changeStatus(UUID id) {
        Optional<BloodDonorModel> bloodDonorOptional = bloodDonorRepository.findById(id);
        if (!bloodDonorOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Este doador não existe na BD!")).build();
        }
        var bloodDonorModel = bloodDonorOptional.get();
        try {
            bloodDonorModel.setStatus(false);
            bloodDonorRepository.save(bloodDonorModel);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_REMOVER)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }

}
