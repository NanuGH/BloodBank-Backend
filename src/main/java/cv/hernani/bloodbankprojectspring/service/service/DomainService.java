package cv.hernani.bloodbankprojectspring.service.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.DomainDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface DomainService {

    public APIResponse createDomain(DomainDto domainDto);
    public APIResponse getAllDomain();
    public APIResponse getDomainById(UUID id);
    public APIResponse deleteDomain(UUID id);
    public APIResponse updateDomain(UUID id, DomainDto domainDto);
    
}
