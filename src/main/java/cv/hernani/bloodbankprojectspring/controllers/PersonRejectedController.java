package cv.hernani.bloodbankprojectspring.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cv.hernani.bloodbankprojectspring.dtos.PersonRejectedDto;
import cv.hernani.bloodbankprojectspring.service.service.PersonRejectedService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/personrejected")
public class PersonRejectedController {
    
    @Autowired
    private final PersonRejectedService personRejectedService;

    public PersonRejectedController(PersonRejectedService personRejectedService) {
        this.personRejectedService = personRejectedService;
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{idPessoa}")
    public ResponseEntity<Object> createBloodCollect(@Valid @RequestBody PersonRejectedDto personRejectedDto,
                                                    @PathVariable("idPessoa") UUID idPessoa) {
        APIResponse response = personRejectedService.createPersonRejected(personRejectedDto,idPessoa);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object>getAllBloodCollect(){
        APIResponse response = personRejectedService.getAllPersonRejected();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Object> getBloodCollectById(@PathVariable("id") UUID id) {
        APIResponse response = personRejectedService.getPersonRejectedById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Object> deleteBloodCollect(@PathVariable("id") UUID id){
        APIResponse response = personRejectedService.delPersonRejected(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBloodColeect(@PathVariable(value = "id") UUID id,@RequestBody @Valid PersonRejectedDto personRejectedDto){        
        APIResponse response = personRejectedService.updtPersonRejected(id,personRejectedDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
