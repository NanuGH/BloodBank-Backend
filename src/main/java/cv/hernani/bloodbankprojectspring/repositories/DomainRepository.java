package cv.hernani.bloodbankprojectspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.hernani.bloodbankprojectspring.models.DomainModel;

public interface DomainRepository extends JpaRepository<DomainModel, UUID>{
    boolean existsByDomainAndDmCode(String domain, String dmCode);
    
}
