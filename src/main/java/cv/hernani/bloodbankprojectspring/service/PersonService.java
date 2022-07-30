package cv.hernani.bloodbankprojectspring.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;

    /*criar um ponto de injeccao do repository
    service é uma camada interm. entre o controller e o repository
    aciona o repository qdo precisa fazer CRUD de uma pessoa
    CONTROLLER aciona SERVICE q por sua vez REPOSITORIE*/
@Service
public class PersonService {    

    /*@Autowired //injeta uma dependencia
    PersonRepositories personRepository;
    uma forma de fazer*/

    final PersonRepository personRepository;

     //cria um construtor e passa a dependencia necessaria como parametro
    public PersonService(PersonRepository personRepository){
       this.personRepository = personRepository;
    }


}
