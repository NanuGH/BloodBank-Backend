package cv.hernani.bloodbankprojectspring.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.hernani.bloodbankprojectspring.models.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {

    boolean existsByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
    //Optional<EmployeeModel> findByEmail(String email);
    List<EmployeeModel> findByIdentifNumberAndEmail(String identifNumber, String email);
    List<EmployeeModel> findByIdentifNumber(String identifNumber);
    List<EmployeeModel> findByEmail(String email);





    

    List<EmployeeModel> findByIdentifNumberAndIdPerson_EmailContainingAllIgnoreCase(String identifNumber, String email);
    List<EmployeeModel> findByIdentifNumberAndIdPerson_NamePersonContainingAllIgnoreCase(String identifNumber, String namePerson);

    List<EmployeeModel> findByEmailAndIdPerson_NamePersonContainingAllIgnoreCase(String email, String namePerson);
    List<EmployeeModel> findByEmailAndIdentifNumberContainingAllIgnoreCase(String email, String identifNumber);

    List<EmployeeModel> findByIdPerson_NamePersonAndIdentifNumberContainingAllIgnoreCase(String namePerson, String identifNumber);
    List<EmployeeModel> findByIdPerson_NamePersonAndEmailContainingAllIgnoreCase(String namePerson, String email);

    List<EmployeeModel> findByIdPerson_NamePersonContainingAllIgnoreCase(String namePerson);
    List<EmployeeModel> findByIdentifNumberContainingAllIgnoreCase(String identifNumber);
    List<EmployeeModel> findByEmailContainingAllIgnoreCase(String email);

    List<EmployeeModel> findByidentifNumberAndIdPerson_NamePersonAndEmailContainingAllIgnoreCase(String identifNumber,String namePerson,String email);

}