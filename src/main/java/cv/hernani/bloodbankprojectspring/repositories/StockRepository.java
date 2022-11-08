package cv.hernani.bloodbankprojectspring.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;
import cv.hernani.bloodbankprojectspring.models.StockModel;

public interface StockRepository extends JpaRepository<StockModel,UUID>{
    boolean existsByCollection(BloodCollectionModel collection);
    Optional <StockModel> findByCollection(String collection);
    boolean existsByCollection(String collection);
}

  