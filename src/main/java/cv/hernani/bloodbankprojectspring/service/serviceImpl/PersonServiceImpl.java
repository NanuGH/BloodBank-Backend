package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import cv.hernani.bloodbankprojectspring.dtos.PersonDto;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;
import cv.hernani.bloodbankprojectspring.service.service.PersonService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.Helper;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class PersonServiceImpl implements PersonService {

    final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public APIResponse createPerson(@RequestBody @Valid PersonDto personDto) {
        /*
         * if
         * (personRepository.existsByNamePersonAndSurnamePersonAndDmDocIdent(personDto.
         * getNamePerson(),personDto.getSurnamePerson(),personDto.getDmDocIdent())
         * ||(personRepository.existsByDmDocIdent(personDto.getDmDocIdent()))){
         */// don't allow duplicated ID's, I will used it after I tested other stuffs
        if (personRepository.existsByNamePersonAndSurnamePersonAndDmDocIdent(personDto.getNamePerson(),
                                                                             personDto.getSurnamePerson(),
                                                                             personDto.getDmDocIdent())) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Este Funcionário já existe na BD!"))
                    .build();
        }

        var personModel = new PersonModel();
        BeanUtils.copyProperties(personDto, personModel);
        personModel.setStatus(true);
        try {
            personRepository.saveAndFlush(personModel);
            return APIResponse.builder().status(true)
                    .message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList(e.getMessage())).build();
        }

    }

    @Override
    public APIResponse updatePerson(UUID id, @RequestBody @Valid PersonDto personDto) {
        Optional<PersonModel> personModelOptional = personRepository.findById(id);
        if (!personModelOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Esta pessoa não existe na BD!")).build();
        }
       /*  if (personRepository.existsByNamePersonAndSurnamePersonAndDmDocIdent(personDto.getNamePerson(),personDto.getSurnamePerson(), personDto.getDmDocIdent())) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Esta pessoa já existe na BD!")).build();
        } */
        var personModel = personModelOptional.get();
        try {
            BeanUtils.copyProperties(personDto, personModel);
            personModel.setId(personModelOptional.get().getId());
            personModel.setStatus(true);
            personRepository.save(personModel);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse changeStatus(UUID id) {
        Optional<PersonModel> personModelOptional = personRepository.findById(id);
        if (!personModelOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: Esta pessoa não existe na BD!")).build();
        }
        var personModel = personModelOptional.get();
        try {
            personModel.setStatus(false);
            personRepository.save(personModel);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_REMOVER)
            .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getPersonByOptionals(String namePerson, String surnamePerson, String birthday) {
        
       LocalDate convertedData = Helper.convertStringLocalDate(birthday);
        try {
            List<PersonModel> getPersons = new ArrayList<>();
            if (namePerson != null && surnamePerson != null && birthday != null) {
                getPersons = personRepository.findByNamePersonAndSurnamePersonAndBirthdayAndStatusIsTrue(namePerson, surnamePerson,convertedData);
                System.out.println("todos");
            }
            if (namePerson == null && surnamePerson!= null && birthday == null ) {
                getPersons = personRepository.findBySurnamePerson(surnamePerson);
                System.out.println("apelido");
            }
            if(namePerson != null && surnamePerson == null && birthday == null) {
                getPersons = personRepository.findByNamePerson(namePerson);
                System.out.println("nome");
            }
            if (namePerson == null && surnamePerson == null && birthday != null) {   
                getPersons = personRepository.findByBirthday(convertedData);
                System.out.println("data nasc");
            }
            //
            if (namePerson != null && surnamePerson != null && birthday == null) {   
                getPersons = personRepository.findByNamePersonAndSurnamePerson(namePerson, surnamePerson);
                System.out.println("nome e apelido");
            }
            if (namePerson != null && surnamePerson == null && birthday != null) {   
                getPersons = personRepository.findByNamePersonAndBirthday(namePerson, convertedData);
                System.out.println("nome e data nasc");
            }
            if (namePerson == null && surnamePerson != null && birthday != null) {   
                getPersons = personRepository.findBySurnamePersonAndBirthday(surnamePerson, convertedData);
                System.out.println("apelido e data nasc");
            }
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(getPersons)).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }

    }

    @Override
    public APIResponse getPersonByOne(String value) {

        List<PersonModel> personModelOptional = personRepository.findByNamePersonOrDmDocIdent(value, value);
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(personModelOptional.toArray())).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getAllPerson() {
        List<PersonModel> getAll = personRepository.findAll();
        try {
            return APIResponse.builder().status(true)
                    .message(MessageState.SUCESSO)
                    .details(Arrays.asList(getAll)).build();
        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getPersonById(UUID id) {
        if (!personRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Esta pessoa não existe na BD!"))
                    .build();
        }
        Optional<PersonModel> personModel = personRepository.findById(id);
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(personModel))
                    .build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage()))
                    .build();
        }
    }

    @Override
    public APIResponse deletePerson(UUID id) {
        if (!personRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Domain dont exists on DB!")).build();
        }
        try {
            personRepository.deleteById(id);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).details(Arrays.asList(e.getMessage())).build();
        }
    }

   
}