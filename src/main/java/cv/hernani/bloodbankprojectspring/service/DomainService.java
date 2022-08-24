package cv.hernani.bloodbankprojectspring.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import cv.hernani.bloodbankprojectspring.dtos.DomainDto;
import cv.hernani.bloodbankprojectspring.models.DomainModel;

public interface DomainService {

    public ResponseEntity<Object> createDomain(DomainDto domainDto);
    public ResponseEntity<Object> updateDomain(UUID id, DomainDto domainDto);
    public ResponseEntity<Object> deleteDomain(UUID id);
    public ResponseEntity<List<DomainModel>> getAllDomain();
    public ResponseEntity<Object> getDomainById(UUID id);    
}
