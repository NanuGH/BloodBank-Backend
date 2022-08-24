package cv.hernani.bloodbankprojectspring.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.DomainDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface DomainService {

    public APIResponse createDomain(DomainDto domainDto);
    public APIResponse getDomain();
    /*public ResponseEntity<Object> updateDomain(UUID id, DomainDto domainDto);
    public ResponseEntity<Object> deleteDomain(UUID id);
    public ResponseEntity<List<DomainModel>> getAllDomain();
    public ResponseEntity<Object> getDomainById(UUID id);    */
    public abstract void deleteDomain(UUID id);
    public APIResponse deletDomain(UUID id);
}
