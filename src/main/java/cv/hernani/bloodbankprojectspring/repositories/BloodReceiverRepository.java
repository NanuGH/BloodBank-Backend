package cv.hernani.bloodbankprojectspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;
import cv.hernani.bloodbankprojectspring.models.BloodReceiverModel;

public interface BloodReceiverRepository extends JpaRepository<BloodReceiverModel,UUID>{
    boolean existsByIdBloodCollect(BloodCollectionModel idBloodCollect);
}
