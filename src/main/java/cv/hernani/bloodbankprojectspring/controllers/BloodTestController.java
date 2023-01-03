package cv.hernani.bloodbankprojectspring.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import cv.hernani.bloodbankprojectspring.dtos.BloodDonorCreateDto;
import cv.hernani.bloodbankprojectspring.dtos.BloodDonorDto;
import cv.hernani.bloodbankprojectspring.dtos.BloodTestDto;
import cv.hernani.bloodbankprojectspring.service.service.BloodDonorService;
import cv.hernani.bloodbankprojectspring.service.service.BloodTestService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/blooddonor")
public class BloodTestController {

    @Autowired
    private final BloodTestService bloodTestServ;

    public BloodTestController(BloodTestService bloodTestServ) {
        this.bloodTestServ = bloodTestServ;
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{idFunc}/{idPessoa}")
    public ResponseEntity<Object> createBloodDonor(@Valid @RequestBody BloodTestDto bloodTestDto,
                                                   @PathVariable("idFunc") UUID idFunc,
                                                   @PathVariable("idPessoa") UUID idSample) {
        APIResponse response = bloodTestServ.createBloodTest(bloodTestDto, idFunc, idSample);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object>getAllBloodDonner(){
        APIResponse response = bloodTestServ.getAllBloodTest();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Object> getBloodCollectById(@PathVariable("id") UUID id) {
        APIResponse response = bloodTestServ.getBloodTestById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    

  /*   @PutMapping("/{idDonner}/{idEmpl}")
    public ResponseEntity<Object> updatelBloodDonor(@PathVariable(value = "idDonner") UUID idDonner,
                                                    @PathVariable(value = "idEmpl") UUID idEmpl,
                                                    @RequestBody @Valid BloodDonorDto bloodDonorDto){        
        APIResponse response = bloodTestServ.updtBloodDonor(idDonner,idEmpl,bloodDonorDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "/changestatus/{id}")
    public ResponseEntity<Object> changeStatus(@PathVariable("id") UUID id) {
        APIResponse response = bloodTestServ.changeStatus(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    } */
    
}
