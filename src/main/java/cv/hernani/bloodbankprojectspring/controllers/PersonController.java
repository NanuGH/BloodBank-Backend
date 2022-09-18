package cv.hernani.bloodbankprojectspring.controllers;

import java.time.LocalDate;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cv.hernani.bloodbankprojectspring.dtos.PersonDto;
import cv.hernani.bloodbankprojectspring.service.service.PersonService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;         

/*recebe as solicitacoes CRUD  e aciona o 
service q aciona o repository*/

@RestController
@CrossOrigin(origins="*", maxAge=3600)//permite q seja acessado d qq fonte
@RequestMapping("/person")//definir URI a nivel de classe
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createDomain(@Valid @RequestBody PersonDto personDto) {
        APIResponse response = personService.createPerson(personDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping()
    public ResponseEntity<Object> getAllDomain() {
        APIResponse response = personService.getAllPerson();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getPersonOpts")
    public ResponseEntity<Object> getPersonOptional(@RequestParam(required=false)String namePerson,
                                                    @RequestParam(required=false) String surnamePerson,
                                                    @RequestParam(required=false) LocalDate birthday) {
        APIResponse response = personService.getPersonByOptionals(namePerson, surnamePerson, birthday);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<Object> getDomainById(@PathVariable("id") UUID id){
        APIResponse response = personService.getPersonById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletDomain(@PathVariable("id") UUID id){
       APIResponse response = personService.deletePerson(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Object> updateDomain(@PathVariable("id") UUID id, 
                                               @RequestBody @Valid PersonDto personDto){

        APIResponse response = personService.updatePerson(id, personDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    




    
   /* //ponto de injecao do service no controller
    final PersonService personService;
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Object> createPerson(@RequestBody @Valid PersonDto personDto){
        
        if(personService.existPerson(personDto.getNamePerson(),personDto.getSurnamePerson(), personDto.getDmDocIdent())){
            return ResponseEntity.status(HttpStatus.CREATED).body("Conflict: Person already exists on DB!");
        }

        //System.out.println("BORORO " + personDto.getBirthday());
        var personModel = new PersonModel();
        BeanUtils.copyProperties(personDto, personModel);//converter DTO em Model para salvar no BD
    
        personModel.setInsertionDate(LocalDateTime.now(ZoneId.of("UTC")));
        personModel.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
    
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(personModel));
    }

    
    @GetMapping
    public ResponseEntity<List<PersonModel>> getAllPerson(){
        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPersonById(@PathVariable(value = "id") UUID id){
        Optional<PersonModel> personModelOptional = personService.findPersonById(id);
        if (!personModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(personModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable(value = "id") UUID id){
        Optional<PersonModel> personModelOptional =  personService.findPersonById(id);

        if(!personModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
        }
        personService.deletePerson(personModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("deleted!");
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable(value="id") UUID id,
                                               @RequestBody @Valid PersonDto personDto){
        Optional<PersonModel> personModelOptional = personService.findPersonById(id);
        if (!personModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found.");
        }

        var personModel = new PersonModel();
        BeanUtils.copyProperties(personDto, personModel);
        personModel.setId(personModelOptional.get().getId());
        personModel.setInsertionDate(personModelOptional.get().getInsertionDate());     
        personModel.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.OK).body(personService.createPerson(personModel));

    }
*/
}
