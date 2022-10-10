package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.BloodDonorDto;
import cv.hernani.bloodbankprojectspring.models.BloodDonorModel;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.repositories.BloodDonorRepository;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;
import cv.hernani.bloodbankprojectspring.service.service.BloodDonorService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class BloodDonorServImpl implements BloodDonorService{

    final BloodDonorRepository bloodDonorRepository;
    final PersonRepository personRepository;
    public BloodDonorServImpl(BloodDonorRepository bloodDonorRepository, PersonRepository personRepository) {
        this.bloodDonorRepository = bloodDonorRepository;
        this.personRepository = personRepository;
    }

    @Override
    public APIResponse createBloodDonor(BloodDonorDto bloodDonorDto, UUID idPerson) {
        Optional<PersonModel> personModelOptional = personRepository.findById(idPerson);
        if (!personModelOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Esta pessoa não existe na BD!"))
                    .build();
        }
        var bloodDonorModel = new BloodDonorModel();

        try {
            BeanUtils.copyProperties(bloodDonorDto,bloodDonorModel);
            bloodDonorModel.setIdPerson(personModelOptional.get());
            bloodDonorModel.setWhoInserted(bloodDonorDto.getWhoInserted());
            bloodDonorModel.setWhoUpdated(bloodDonorDto.getWhoUpdated());
            bloodDonorRepository.save(bloodDonorModel);
            
            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }
    }

    @Override
    public APIResponse updtBloodDonor(UUID id, BloodDonorDto bloodDonorDto) {
        Optional<BloodDonorModel> bloodDonorOptional = bloodDonorRepository.findById(id);
        if (!bloodDonorOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: Colheita nao existe na BD!")).build();
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
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();
        }  
    }

    @Override
    public APIResponse getAllBloodDonor() {
        List<BloodDonorModel> getAllBloodDonor = bloodDonorRepository.findAll();
   
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(getAllBloodDonor)).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getBloodDonorById(UUID id) {
        if (!bloodDonorRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Domain dont exists on DB!")).build();
        }
        Optional<BloodDonorModel> bloodDonorModel = bloodDonorRepository.findById(id);
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(bloodDonorModel)).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    
    
    @Override
    public APIResponse delBloodDonor(UUID id) {
        if (!bloodDonorRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Domain dont exists on DB!")).build();
        }
        try {
            bloodDonorRepository.deleteById(id);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).details(Arrays.asList(e.getMessage())).build();
        }
    }

}
