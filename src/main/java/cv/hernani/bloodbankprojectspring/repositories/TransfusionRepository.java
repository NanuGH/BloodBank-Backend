package cv.hernani.bloodbankprojectspring.repositories;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.hernani.bloodbankprojectspring.models.TransfusionModel;

public interface TransfusionRepository extends JpaRepository<TransfusionModel,UUID> {

    boolean existsByTransfNumber(TransfusionModel transfNumber);
    Optional <TransfusionModel> findByTransfNumberContainingAllIgnoreCase(String transfNumber);
    
}
