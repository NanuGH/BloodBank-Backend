package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.PersonRejectedDto;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.models.PersonRejectedModel;
import cv.hernani.bloodbankprojectspring.repositories.PersonRejectedRepository;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;
import cv.hernani.bloodbankprojectspring.service.service.PersonRejectedService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class PersonRejectedServImpl implements PersonRejectedService {

    final PersonRejectedRepository personRejectedRepository;
    final PersonRepository personRepository;

    public PersonRejectedServImpl(PersonRejectedRepository personRejectedRepository,
            PersonRepository personRepository) {
        this.personRejectedRepository = personRejectedRepository;
        this.personRepository = personRepository;
    }

    @Override
    public APIResponse createPersonRejected(PersonRejectedDto personRejectedDto, UUID idPerson) {
        Optional<PersonModel> personModelOptional = personRepository.findById(idPerson);
        if (!personModelOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Essa pessoa não existe na BD!"))
                    .build();
        }
        
        var personRejectedModel = new PersonRejectedModel();
        var personModel = personModelOptional.get();
        try {
            BeanUtils.copyProperties(personRejectedDto,personRejectedModel);
            personRejectedModel.setIdPerson(personModelOptional.get());
            personRejectedModel.setWhoInserted(personRejectedDto.getWhoInserted());
            personRejectedModel.setWhoUpdated(personRejectedDto.getWhoUpdated());
            personRejectedModel.setDmCodeDisabled(personRejectedDto.getRejectionCode());
            personRejectedModel.setStatus("true");
            personRejectedRepository.save(personRejectedModel); 
            /******** */    
            personModel.setStatus("ttttttt");
            personModel.setWhoUpdated(personRejectedDto.getWhoUpdated());
            personRepository.save(personModel);

            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }
    }

    @Override
    public APIResponse updtPersonRejected(UUID id, PersonRejectedDto personRejectedDto) {
        Optional<PersonRejectedModel> personRejectedOptional = personRejectedRepository.findById(id);
        if (!personRejectedOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: Esta rejeição nao existe na BD!")).build();
        }
        var personRejectedModel = personRejectedOptional.get();   

        try {
            BeanUtils.copyProperties(personRejectedDto, personRejectedModel);
            personRejectedModel.setDmCodeDisabled(personRejectedDto.getRejectionCode());
            personRejectedModel.setWhoUpdated(personRejectedDto.getWhoUpdated());
            personRejectedRepository.save(personRejectedModel);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();
        }  
    }

    @Override
    public APIResponse getAllPersonRejected() {
        List<PersonRejectedModel> getAllPersonRejected = personRejectedRepository.findAll();
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(getAllPersonRejected)).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getPersonRejectedById(UUID id) {
        if (!personRejectedRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("ERRO: Esta pessoa não existe na BD!")).build();
        }
        Optional<PersonRejectedModel> personRejectedModel = personRejectedRepository.findById(id);
        try {

            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(personRejectedModel)).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse delPersonRejected(UUID id) {
        if (!personRejectedRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("ERRO: Esta pessoa não existe na BD!!")).build();
        }
        try {
            personRejectedRepository.deleteById(id);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).details(Arrays.asList(e.getMessage())).build();
        }
    }
    
}
