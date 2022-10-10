package cv.hernani.bloodbankprojectspring.repositories;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;

@Repository
public interface BloodCollectionRepository extends JpaRepository<BloodCollectionModel,UUID>{
    
    List<BloodCollectionModel> findByCollectionNumberAndInsertionDate(String collectionNumber, LocalDateTime insertionDate);
    List<BloodCollectionModel> findByCollectionNumber(String collectionNumber);
    List<BloodCollectionModel> findByInsertionDate(LocalDateTime insertionDate);
}
