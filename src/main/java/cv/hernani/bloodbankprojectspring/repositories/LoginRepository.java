package cv.hernani.bloodbankprojectspring.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.hernani.bloodbankprojectspring.models.EmployeeModel;

public interface LoginRepository extends JpaRepository<EmployeeModel, UUID> {

    Optional<EmployeeModel> findByEmail(String email);    
}
