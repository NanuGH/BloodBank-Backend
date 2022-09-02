package cv.hernani.bloodbankprojectspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.hernani.bloodbankprojectspring.models.DonationRejectedModel;

public interface DonationRejectedRepository extends JpaRepository<DonationRejectedModel,UUID> {
    
}
