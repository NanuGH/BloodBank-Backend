package cv.hernani.bloodbankprojectspring.service;

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

    @Transactional // utilizar princip. qdo existe delete ou insert em cascata 
                   //pq caso algo de erro ele garante um "roll-back" para q tudo volte ao normal
    public PersonModel savePerson (PersonModel personModel){
        return personRepository.save(personModel);
    }

}
