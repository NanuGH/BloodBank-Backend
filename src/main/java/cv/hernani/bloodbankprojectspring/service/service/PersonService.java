package cv.hernani.bloodbankprojectspring.service.service;

import java.time.LocalDate;
import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.PersonDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;


public interface PersonService {
    public APIResponse createPerson(PersonDto domainDto);

    public APIResponse getAllPerson();

    public APIResponse getPersonById(UUID id);

    public APIResponse getPersonByOptionals(String namePerson,String surnamePerson, String birthday);

    public APIResponse deletePerson(UUID id);

    public APIResponse updatePerson(UUID id, PersonDto domainDto);
    
}
