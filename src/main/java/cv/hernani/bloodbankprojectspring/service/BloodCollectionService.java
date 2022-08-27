package cv.hernani.bloodbankprojectspring.service;

import cv.hernani.bloodbankprojectspring.dtos.BloodCollectionDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;


public interface BloodCollectionService {
    APIResponse createBloodColection(BloodCollectionDto bloodCollectionDto);
}
