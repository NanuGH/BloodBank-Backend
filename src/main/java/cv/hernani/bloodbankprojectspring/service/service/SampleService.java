package cv.hernani.bloodbankprojectspring.service.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.SampleDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface SampleService {

    public APIResponse createSample(SampleDto sampleDto, UUID idCollection, UUID idEmployee);
    public APIResponse updateSample(UUID id,SampleDto sampleDto);
    public APIResponse getAllSample();
    public APIResponse getSampleById(UUID id);
    
   
    
    public APIResponse changeStatus(UUID id);
    
}