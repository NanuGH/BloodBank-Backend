package cv.hernani.bloodbankprojectspring.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.hernani.bloodbankprojectspring.models.DomainModel;

public interface DomainRepository extends JpaRepository<DomainModel, UUID>{
    boolean existsByDomainAndDmCode(String domain, String dmCode);
    List<DomainModel> existsByDomain(String domain);
    List<DomainModel> findByDomain(String domain);
    List<DomainModel> findBySelfId(UUID selfId);
    Optional <DomainModel> findByDomainAndSelfIdIsNull(String domain);
    int countByDomainAndSelfIdIsNotNull(String domain);
    
}
