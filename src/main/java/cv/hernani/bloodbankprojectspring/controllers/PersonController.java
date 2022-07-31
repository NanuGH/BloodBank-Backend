package cv.hernani.bloodbankprojectspring.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cv.hernani.bloodbankprojectspring.dtos.PersonDto;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.service.PersonService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

/*recebe as solicitacoes CRUD  e aciona o 
service q aciona o repository*/

@RestController
@CrossOrigin(origins="*", maxAge=3600)//permite q seja acessado d qq fonte
@RequestMapping("/person")//definir URI a nivel de classe
public class PersonController {
    
    //ponto de injecao do service no controller
    final PersonService personService;
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Object> savePerson(@RequestBody @Valid PersonDto personDto){
        var personModel = new PersonModel();
        BeanUtils.copyProperties(personDto, personModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.savePerson(personModel));
    }
   
}
