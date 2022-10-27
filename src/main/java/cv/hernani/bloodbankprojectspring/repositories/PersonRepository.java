package cv.hernani.bloodbankprojectspring.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cv.hernani.bloodbankprojectspring.models.PersonModel;


@Repository
public interface PersonRepository extends JpaRepository<PersonModel, UUID>{
       
    boolean existsByNamePersonAndSurnamePersonAndDmDocIdent(String namePerson, String surnamePerson, String dmDocIdent);
    boolean existsByDmDocIdent(String DocIdent);

    List<PersonModel> findByNamePersonAndSurnamePersonAndBirthday(String namePerson, String surnamePerson, LocalDate birthday);
    List<PersonModel> findByNamePerson(String namePerson);
    List<PersonModel> findBySurnamePerson(String surnamePerson);
    List<PersonModel> findByBirthday(LocalDate birthday);

    List<PersonModel> findByStatus(String status);

    
}
