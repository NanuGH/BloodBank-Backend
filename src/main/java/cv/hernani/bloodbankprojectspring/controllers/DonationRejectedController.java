package cv.hernani.bloodbankprojectspring.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cv.hernani.bloodbankprojectspring.dtos.DonationRejectedDto;
import cv.hernani.bloodbankprojectspring.service.service.DonationRejectedService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/donationRejected")
public class DonationRejectedController {
    
    @Autowired
    final DonationRejectedService donationRejectedService;

    
    public DonationRejectedController(DonationRejectedService donationRejectedService) {
        this.donationRejectedService = donationRejectedService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{idBloodCollect}")
    public ResponseEntity<Object> createDonationRejected(@Valid @RequestBody DonationRejectedDto donationRejectedDto,
                                                         @PathVariable("idBloodCollect") UUID idBloodCollect) {
        APIResponse response = donationRejectedService.createDonationRejected(donationRejectedDto,idBloodCollect);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object>getAllDonationRejected(){
        APIResponse response = donationRejectedService.getAllDonationRejected();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Object> getDonationRejectedById(@PathVariable("id") UUID id) {
        APIResponse response = donationRejectedService.getDonationRejectedById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Object> deleteDonationRejected(@PathVariable("id") UUID id){
        APIResponse response = donationRejectedService.delDonationRejected(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBloodColeect(@PathVariable(value = "id") UUID id,@RequestBody @Valid DonationRejectedDto donationRejectedDto){        
        APIResponse response = donationRejectedService.updtDonationRejected(id,donationRejectedDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
