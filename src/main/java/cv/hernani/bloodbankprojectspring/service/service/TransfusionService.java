package cv.hernani.bloodbankprojectspring.service.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.TransfusionDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface TransfusionService {
    public APIResponse createTransfusion(TransfusionDto transfusionDto,UUID idEmployee,UUID idCollection);
    public APIResponse getAllTransfusion();
    public APIResponse getTransfusionById(UUID id);
    public APIResponse changeStatus(UUID id);
    public APIResponse updateTransfusion(UUID id, TransfusionDto transfusionDto);  
    public APIResponse getTransfNumber(String transfNumber);
}
