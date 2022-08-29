package cv.hernani.bloodbankprojectspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.hernani.bloodbankprojectspring.models.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {
    boolean existsByDmFunctionAndIdentifNumber(String namePerson,String  identifNumber);
}
