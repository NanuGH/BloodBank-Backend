package cv.hernani.bloodbankprojectspring.service.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.BloodDonorDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface BloodDonorService {
    public APIResponse createBloodDonor(BloodDonorDto bloodDonorDto,UUID idEmployee, UUID idPerson);
    public APIResponse updtBloodDonor(UUID id, BloodDonorDto bloodDonorDto);
    public APIResponse getAllBloodDonor();
    public APIResponse getBloodDonorById(UUID id);
    public APIResponse getBloodDonnerBy(String identifNumber);
    public APIResponse delBloodDonor(UUID id);
    public APIResponse changeStatus(UUID id);
}
