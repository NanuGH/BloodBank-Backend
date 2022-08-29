package cv.hernani.bloodbankprojectspring.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.BloodCollectionDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;


public interface BloodCollectionService {
    public APIResponse createBloodCollection(BloodCollectionDto bloodCollectionDto);
    public APIResponse updtBloodCollection(UUID id, BloodCollectionDto bloodCollectionDto);
    public APIResponse getAllBloodCollection();
    public APIResponse getBloodCollectById(UUID id);
    public APIResponse delBloodCollection(UUID id);
     /*boolean existEmployee(String namePerson, String surnamePerson, String identifNumber);*/
}
