package cv.hernani.bloodbankprojectspring.service.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.BloodTestDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface BloodTestService {
    public APIResponse createBloodTest(BloodTestDto bloodTestDto,UUID idEmployee, UUID idSample);
    public APIResponse updtBloodTest(UUID idDonner,UUID idEmpl, BloodTestDto bloodTestDto);
    public APIResponse getAllBloodTest();
    public APIResponse getBloodTestById(UUID id);
    public APIResponse getTestByTestNumber(String testNumber);
    public APIResponse delBloodTest(UUID id);
    public APIResponse changeStatus(UUID id);
}
