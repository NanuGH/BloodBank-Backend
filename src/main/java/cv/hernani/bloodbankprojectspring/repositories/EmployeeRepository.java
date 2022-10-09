package cv.hernani.bloodbankprojectspring.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.hernani.bloodbankprojectspring.models.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {

    boolean existsByEmailAndPw(String email, String pw);
    //Optional<EmployeeModel> findByEmail(String email);
    List<EmployeeModel> findByIdentifNumberAndEmail(String identifNumber, String email);
    List<EmployeeModel> findByIdentifNumber(String identifNumber);
    List<EmployeeModel> findByEmail(String email);
    
}
