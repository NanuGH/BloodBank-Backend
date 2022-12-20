package cv.hernani.bloodbankprojectspring.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import cv.hernani.bloodbankprojectspring.dtos.BloodDonorDto;
import cv.hernani.bloodbankprojectspring.service.service.BloodDonorService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/blooddonor")
public class BloodDonorController {

    @Autowired
    private final BloodDonorService bloodDonorServ;

    public BloodDonorController(BloodDonorService bloodDonorServ) {
        this.bloodDonorServ = bloodDonorServ;
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{idPessoa}")
    public ResponseEntity<Object> createBloodDonor(@Valid @RequestBody BloodDonorDto bloodDonorDto,
                                                     @PathVariable("idPessoa") UUID idPessoa) {
        APIResponse response = bloodDonorServ.createBloodDonor(bloodDonorDto,idPessoa);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object>getAllBloodDonner(){
        APIResponse response = bloodDonorServ.getAllBloodDonor();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Object> getBloodCollectById(@PathVariable("id") UUID id) {
        APIResponse response = bloodDonorServ.getBloodDonorById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Object> deleteBloodCollect(@PathVariable("id") UUID id){
        APIResponse response = bloodDonorServ.delBloodDonor(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatelBloodDonor(@PathVariable(value = "id") UUID id,@RequestBody @Valid BloodDonorDto bloodDonorDto){        
        APIResponse response = bloodDonorServ.updtBloodDonor(id,bloodDonorDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
