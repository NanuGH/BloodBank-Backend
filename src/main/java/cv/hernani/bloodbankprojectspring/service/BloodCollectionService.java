package cv.hernani.bloodbankprojectspring.service;

import cv.hernani.bloodbankprojectspring.dtos.BloodCollectionDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;


public interface BloodCollectionService {
    public APIResponse createBloodColection(BloodCollectionDtopublic bloodCollectionDto);
    public APIResponse updtBloodCollection(UUID id, BloodCollectionDto bloodCollectionDto);
    /*boolean existEmployee(String namePerson, String surnamePerson, String identifNumber);*/
    public APIResponse getAllDomain();
    public APIResponse getBloodCollectById(UUID id);
    public APIResponse delBloodCollection(BloodCollectionModel bloodCollectModel);
}
