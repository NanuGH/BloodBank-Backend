package cv.hernani.bloodbankprojectspring.controllers;

import java.util.UUID;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import cv.hernani.bloodbankprojectspring.dtos.BloodReceiverDto;
import cv.hernani.bloodbankprojectspring.service.service.BloodReceiverService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/bloodreceiver")
public class BloodReceiverContoller {

    private final BloodReceiverService bloodRecService;


    public BloodReceiverContoller(BloodReceiverService bloodRecService) {
        this.bloodRecService = bloodRecService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{idFunc}/{idPessoa}/{idColheita}")
    public ResponseEntity<Object> createBloodCollect(@Valid @RequestBody BloodReceiverDto bloodRecDto, 
                                                     @PathVariable("idFunc") UUID idFunc, 
                                                     @PathVariable("idPessoa") UUID idPessoa,
                                                     @PathVariable("idColheita") UUID idColheita) {

        APIResponse response = bloodRecService.createBloodReceiver(bloodRecDto,idFunc,idPessoa,idColheita);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object>getAllBloodReceiver(){
        APIResponse response = bloodRecService.getAllBloodReceiver();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Object> getBloodRecById(@PathVariable("id") UUID id) {
        APIResponse response = bloodRecService.getBloodReceiverById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Object> deleteBloodCollect(@PathVariable("id") UUID id){
        APIResponse response = bloodRecService.delBloodReceiver(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBloodColeect(@PathVariable(value = "id") UUID id,
                                                     @RequestBody @Valid BloodReceiverDto bloodRecDto){  
                                                              
        APIResponse response = bloodRecService.updtBloodReceiver(id,bloodRecDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
