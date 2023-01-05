package cv.hernani.bloodbankprojectspring.controllers;

import org.springframework.web.bind.annotation.*;

import cv.hernani.bloodbankprojectspring.dtos.TransfusionDto;
import cv.hernani.bloodbankprojectspring.service.service.TransfusionService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/transfusion")
public class TransfusionController {
    
    private final TransfusionService transfusionService;


    public TransfusionController(TransfusionService transfusionService) {
        this.transfusionService = transfusionService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{idEmployee}/{idPerson}/{idStock}")
    public ResponseEntity<Object> createBloodCollect(@PathVariable("idEmployee") UUID idEmployee, 
                                                     @PathVariable("idPerson") UUID idPerson, 
                                                     @PathVariable("idStock") UUID idStock,
                                                     @Valid @RequestBody TransfusionDto transfusionDto) {

        APIResponse response = transfusionService.createTransfusion(idEmployee,idPerson,idStock,transfusionDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object>getAllTransfusion(){
        APIResponse response = transfusionService.getAllTransfusion();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Object> getTransfusionById(@PathVariable("id") UUID id) {
        APIResponse response = transfusionService.getTransfusionById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value ="/transfusion/{transfNumber}")
    public ResponseEntity<Object> getTransfusionByNumber(@PathVariable("transfNumber") String transfNumber) {
        APIResponse response = transfusionService.getTransfNumber(transfNumber);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value ="status/{id}")
    public ResponseEntity<Object> changeStatus(@PathVariable("id") UUID id){
        APIResponse response = transfusionService.changeStatus(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBloodColeect(@PathVariable(value = "id") UUID id,
                                                     @RequestBody @Valid TransfusionDto transfusionDto){  
                                                              
        APIResponse response = transfusionService.updateTransfusion(id, transfusionDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
