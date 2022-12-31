package cv.hernani.bloodbankprojectspring.service.service;

import java.time.LocalDateTime;
import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.BloodCollectionDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;


public interface BloodCollectionService {
    public APIResponse createBloodCollection(BloodCollectionDto bloodCollectionDto, UUID idEmployee, UUID idPerson);

    public APIResponse updtBloodCollection(UUID id, UUID idEmployee, BloodCollectionDto bloodCollectionDto);

    public APIResponse getAllBloodCollection();

    public APIResponse getBloodCollectById(UUID id);

    public APIResponse getBloodCollByNumber(String collectionNumber);

    public APIResponse findBloodCollectByOptionals(String collectionNumber,String insertionDate);

    public APIResponse delBloodCollection(UUID id);

    public APIResponse changeStatus(UUID id);
}
