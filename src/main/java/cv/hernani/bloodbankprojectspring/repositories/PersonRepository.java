package cv.hernani.bloodbankprojectspring.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import cv.hernani.bloodbankprojectspring.models.PersonModel;



public interface PersonRepository extends JpaRepository<PersonModel, UUID>{
       
    boolean existsByNamePersonAndSurnamePersonAndDmDocIdent(String namePerson, String surnamePerson, String dmDocIdent);
    boolean existsByDmDocIdent(String DocIdent);

    List<PersonModel> findByNamePersonAndSurnamePersonAndBirthdayAndStatusIsTrue(String namePerson, String surnamePerson, LocalDate birthday);
    List<PersonModel> findByNamePerson(String namePerson);
    List<PersonModel> findBySurnamePerson(String surnamePerson);
    List<PersonModel> findByBirthday(LocalDate birthday);

    List<PersonModel> findByNamePersonAndSurnamePerson(String namePerson, String surnamePerson );
    List<PersonModel> findByNamePersonAndBirthday(String namePerson, LocalDate birthday );
    List<PersonModel> findBySurnamePersonAndBirthday(String surnamePerson, LocalDate birthday );

    List<PersonModel> findByNamePersonOrDmDocIdent(String namePerson, String dmDocIdent);
    List<PersonModel> findByStatus(String status);

    
}
