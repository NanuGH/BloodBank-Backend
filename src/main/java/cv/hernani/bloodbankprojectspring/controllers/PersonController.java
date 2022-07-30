package cv.hernani.bloodbankprojectspring.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cv.hernani.bloodbankprojectspring.service.PersonService;

/*recebe as solicitacoes CRUD  e aciona o 
service q aciona o repository*/

@RestController
@CrossOrigin(origins="*", maxAge=3600)//permite q seja acessado d qq fonte
@RequestMapping("/person")//definir URL a nivel de classe
public class PersonController {
    
    //ponto de injecao do service no controller
    final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }


    
}
