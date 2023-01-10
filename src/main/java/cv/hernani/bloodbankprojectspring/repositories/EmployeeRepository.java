package cv.hernani.bloodbankprojectspring.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.hernani.bloodbankprojectspring.models.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {

    boolean existsByEmailAndPassword(String email, String password);
    //Optional<EmployeeModel> findByEmail(String email);
    List<EmployeeModel> findByIdentifNumberAndEmail(String identifNumber, String email);
    List<EmployeeModel> findByIdentifNumber(String identifNumber);
    List<EmployeeModel> findByEmail(String email);





    

    List<EmployeeModel> findByIdentifNumberAndIdPerson_EmailContainingAllIgnoreCase(String identifNumber, String email);
    List<EmployeeModel> findByIdentifNumberAndIdPerson_NamePersonContainingAllIgnoreCase(String identifNumber, String namePerson);

    List<EmployeeModel> findByEmailAndIdPerson_NamePersonContainingAllIgnoreCase(String email, String namePerson);
    List<EmployeeModel> findByEmailAndIdentifNumberContainingAllIgnoreCase(String email, String identifNumber);

    List<EmployeeModel> findByEmailAndIdentifNumberContainingAllIgnoreCase(String namePerson, String identifNumber);

    
}
