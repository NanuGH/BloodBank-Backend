package cv.hernani.bloodbankprojectspring.service.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;

import cv.hernani.bloodbankprojectspring.dtos.BloodReceiverDto;
import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;
import cv.hernani.bloodbankprojectspring.models.BloodReceiverModel;
import cv.hernani.bloodbankprojectspring.models.EmployeeModel;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.repositories.BloodCollectionRepository;
import cv.hernani.bloodbankprojectspring.repositories.BloodReceiverRepository;
import cv.hernani.bloodbankprojectspring.repositories.EmployeeRepository;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;
import cv.hernani.bloodbankprojectspring.service.BloodReceiverService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

public class BloodReciverServImpl implements BloodReceiverService {

    final BloodReceiverRepository bloodRecRep;
    final BloodCollectionRepository bloodCollectRep;
    final PersonRepository personRep;
    final EmployeeRepository employeeRep;

    public BloodReciverServImpl(BloodReceiverRepository bloodRecRep, BloodCollectionRepository bloodCollectRep,
                                PersonRepository personRep, EmployeeRepository employeeRep) {
        this.bloodRecRep = bloodRecRep;
        this.bloodCollectRep = bloodCollectRep;
        this.personRep = personRep;
        this.employeeRep = employeeRep;
    }

    

    @Override
    public APIResponse createBloodReceiver(@RequestBody @Valid BloodReceiverDto bloodRecDto, 
                                           UUID idEmployee,UUID idPerson, UUID idBloodCollect) {

        Optional<PersonModel> personModelOptional = personRep.findById(idPerson);
        if (!personModelOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Essa pessoa não existe na BD!"))
                    .build();
        }

        Optional<EmployeeModel> employeeModelOptional = employeeRep.findById(idEmployee);
        if (!employeeModelOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Este funcionário não existe na BD"))
                    .build();
        }

        Optional<BloodCollectionModel> bloodCollOptional = bloodCollectRep.findById(idBloodCollect);
        if (!bloodCollOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Esta Colheita não existe na BD"))
                    .build();
        }

        var bloodRecModel = new BloodReceiverModel();
        try {
            BeanUtils.copyProperties(bloodRecDto, bloodRecModel);
            bloodRecModel.setIdPerson(personModelOptional.get());
            bloodRecModel.setIdEmployee(employeeModelOptional.get());
            bloodRecModel.setWhoInserted(bloodRecDto.getWhoInserted());
            bloodRecModel.setWhoUpdated(bloodRecDto.getWhoUpdated());
            bloodRecRep.save(bloodRecModel);
            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
            
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }    
    }

    @Override
    public APIResponse updtBloodReceiver(UUID id,@RequestBody @Valid BloodReceiverDto bloodReceiverDto) {
        Optional<BloodReceiverModel> bloodRecOptional = bloodRecRep.findById(id);
        if (!bloodRecOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                              .details(Arrays.asList("ERRO: Colheita nao existe na BD!")).build();
        }
        var bloodRecModel = new BloodReceiverModel();

        try {
            BeanUtils.copyProperties(bloodReceiverDto, bloodRecModel);
            bloodRecModel.setId(bloodRecOptional.get().getId());
            bloodRecModel.setIdPerson(bloodRecOptional.get().getIdPerson());
            bloodRecModel.setIdEmployee(bloodRecOptional.get().getIdEmployee());
            bloodRecModel.setWhoUpdated(bloodRecOptional.get().getWhoUpdated());
            bloodRecRep.save(bloodRecModel);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR)
                                                             .details(Arrays.asList(e.getMessage())).build();
        } 
    }

    @Override
    public APIResponse getAllBloodReceiver() {
        List<BloodReceiverModel> getAllBloodRec = bloodRecRep.findAll();
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(getAllBloodRec)).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getBloodReceiverById(UUID id) {
        if (!bloodRecRep.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Domain dont exists on DB!")).build();
        }
        Optional<BloodReceiverModel> bloodRecModel = bloodRecRep.findById(id);
        try {

            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(bloodRecModel)).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse delBloodReceiver(UUID id) {
        if (!bloodRecRep.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Domain dont exists on DB!")).build();
        }
        try {
            bloodRecRep.deleteById(id);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).details(Arrays.asList(e.getMessage())).build();
        }
    }

}
