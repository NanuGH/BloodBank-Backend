package cv.hernani.bloodbankprojectspring.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cv.hernani.bloodbankprojectspring.dtos.PersonDto;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.service.PersonService;         

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
    public ResponseEntity<Object> createPerson(@RequestBody @Valid PersonDto personDto){
        System.out.println("BORORO " + personDto.getBirthday());
        var personModel = new PersonModel();
        BeanUtils.copyProperties(personDto, personModel);//converter DTO em Model para salvar no BD
    
        personModel.setInsertionDate(LocalDateTime.now(ZoneId.of("UTC")));
        personModel.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
    
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(personModel));
    }
   
}
