package cv.hernani.bloodbankprojectspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;

public interface BloodCollectionRepository extends JpaRepository<BloodCollectionModel,UUID>{
    
}
