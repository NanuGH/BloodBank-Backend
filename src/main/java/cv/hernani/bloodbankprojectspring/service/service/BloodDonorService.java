package cv.hernani.bloodbankprojectspring.service.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.BloodDonorCreateDto;
import cv.hernani.bloodbankprojectspring.dtos.BloodDonorDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface BloodDonorService {
    public APIResponse createBloodDonor(BloodDonorCreateDto bloodDonorCreateDto,UUID idEmployee, UUID idPerson);
    public APIResponse updtBloodDonor(UUID idDonner,UUID idEmpl, BloodDonorDto bloodDonorDto);
    public APIResponse getAllBloodDonor();
    public APIResponse getBloodDonorById(UUID id);
    public APIResponse getBloodDonnerBy(String identifNumber);
    public APIResponse delBloodDonor(UUID id);
    public APIResponse changeStatus(UUID id);
}
