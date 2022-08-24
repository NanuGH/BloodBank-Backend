package cv.hernani.bloodbankprojectspring.service.ServiceImplement;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.DomainDto;
import cv.hernani.bloodbankprojectspring.models.DomainModel;
import cv.hernani.bloodbankprojectspring.repositories.DomainRepository;
import cv.hernani.bloodbankprojectspring.service.DomainService;

@Service
public class DomainServiceImpl implements DomainService {

    private final DomainService domainService;
    private final DomainRepository domainRepository;

    @Override
    public ResponseEntity<Object> createDomain(DomainDto domainDto) {
        if(dom){
            
        return null;
        }
    }

    @Override
    public ResponseEntity<Object> updateDomain(UUID id, DomainDto domainModel) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteDomain(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<List<DomainModel>> getAllDomain() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<Object> getDomainById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

   
}
