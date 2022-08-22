package cv.hernani.bloodbankprojectspring.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;

/*criar um ponto de injeccao do repository
service é uma camada intermed. entre o controller e o repository
aciona o repository qdo precisa fazer CRUD de uma pessoa
CONTROLLER aciona SERVICE q por sua vez REPOSITORIE*/
@Service
public class PersonService {

    /* //injeta uma dependencia(uma forma de fazer)
     * @Autowired
     * PersonRepositories personRepository;
     */
    /*criar um construtor e passar a dependencia necessaria como parametro
     (outra forma) */
    
    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /*/ utilizar princip. qdo existe delete ou insert em cascata 
    //pq caso algo de erro ele garante um "roll-back" para q tudo volte ao normal*/
    @Transactional 
    public PersonModel createPerson (PersonModel personModel){
        return personRepository.save(personModel);
    }

    public boolean existPerson(String namePerson, String surnamePerson, String dmDocIdent) {
        return personRepository.existsByNamePersonAndSurnamePersonAndDmDocIdent(namePerson, surnamePerson, dmDocIdent);
    }

    public List<PersonModel> findAll() {
        return personRepository.findAll();
    }

	public Optional<PersonModel> findPersonById(UUID id) {
		return personRepository.findById(id);
	}

    @Transactional 
	public void deletePerson(PersonModel personModel) {
		personRepository.delete(personModel);
	}




}
