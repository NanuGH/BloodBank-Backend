package cv.hernani.bloodbankprojectspring.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.BloodReceiverDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface BloodReceiverService {
    public APIResponse createBloodReceiver(BloodReceiverDto bloodCollectionDto, 
                                           UUID idEmployee, UUID idPerson, UUID idBloodCollect);
    public APIResponse updtBloodReceiver(UUID id, BloodReceiverDto bloodReceiverDto);
    public APIResponse getAllBloodReceiver();
    public APIResponse getBloodReceiverById(UUID id);
    public APIResponse delBloodReceiver(UUID id);
}
