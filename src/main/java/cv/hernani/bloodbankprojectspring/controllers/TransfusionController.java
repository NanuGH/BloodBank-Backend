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

  /* @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{idEmployee}/{idPerson}/{idCollection}")
    public ResponseEntity<Object> createBloodCollect(@Valid @RequestBody TransfusionDto transfusionDto, 
                                                     @PathVariable("idEmployee") UUID idEmployee, 
                                                     @PathVariable("idPerson") UUID idPerson,
                                                     @PathVariable("idCollection") UUID idCollection) {

        APIResponse response = transfusionService.createTransfusion(transfusionDto,idEmployee,idPerson,idCollection);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
*/
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

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Object> deleteBloodCollect(@PathVariable("id") UUID id){
        APIResponse response = transfusionService.deleteTransfusion(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBloodColeect(@PathVariable(value = "id") UUID id,
                                                     @RequestBody @Valid TransfusionDto transfusionDto){  
                                                              
        APIResponse response = transfusionService.updateTransfusion(id, transfusionDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
