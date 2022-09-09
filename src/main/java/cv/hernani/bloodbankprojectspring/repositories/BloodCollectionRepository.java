package cv.hernani.bloodbankprojectspring.repositories;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;

@Repository
public interface BloodCollectionRepository extends JpaRepository<BloodCollectionModel,UUID>{
    
}
