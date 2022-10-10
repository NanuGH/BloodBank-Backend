package cv.hernani.bloodbankprojectspring.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.hernani.bloodbankprojectspring.models.BloodDonorModel;

public interface BloodDonorRepository extends JpaRepository<BloodDonorModel, UUID> {

}
