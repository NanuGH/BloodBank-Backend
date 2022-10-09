package cv.hernani.bloodbankprojectspring.repositories;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;

@Repository
public interface BloodCollectionRepository extends JpaRepository<BloodCollectionModel,UUID>{
    
    /* List<BloodCollectionModel> findByIdentifNumberAndInsertionDate(String identifNumber, String insertionDate);
    List<BloodCollectionModel> findByIdentifNumber(String identifNumber); */
    List<BloodCollectionModel> findByInsertionDate(String insertionDate);
}
