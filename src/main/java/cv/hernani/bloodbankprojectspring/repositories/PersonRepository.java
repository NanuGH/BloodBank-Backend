package cv.hernani.bloodbankprojectspring.repositories;

import java.util.List;
import java.util.UUID;

//ter acesso a metodos prontos para realizar transacoes c o BD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cv.hernani.bloodbankprojectspring.models.PersonModel;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, UUID>{
       
    boolean existsByNamePersonAndSurnamePersonAndDmDocIdent(String namePerson, String surnamePerson, String dmDocIdent);
    boolean existsByDmDocIdent(String DocIdent);
    List<PersonModel> findByNamePersonAndSurnamePerson(String namePerson, String surnamePerson);
    List<PersonModel> findByNamePerson(String namePerson);
    List<PersonModel> findBySurnamePerson(String surnamePerson);
    
}
