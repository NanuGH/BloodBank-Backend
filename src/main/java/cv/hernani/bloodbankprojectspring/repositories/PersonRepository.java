package cv.hernani.bloodbankprojectspring.repositories;

import java.util.UUID;

//ter acesso a metodos prontos para realizar transacoes c o BD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cv.hernani.bloodbankprojectspring.models.PersonModel;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, UUID>{
       

}
