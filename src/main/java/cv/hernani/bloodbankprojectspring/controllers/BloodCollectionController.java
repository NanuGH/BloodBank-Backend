package cv.hernani.bloodbankprojectspring.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import cv.hernani.bloodbankprojectspring.dtos.BloodCollectionDto;
import cv.hernani.bloodbankprojectspring.service.BloodCollectionService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

@CrossOrigin
@RestController
@RequestMapping(path = "/bloodcollection")
public class BloodCollectionController {
    
    @Autowired
    private final BloodCollectionService bloodCollectServ;

    public BloodCollectionController(BloodCollectionService bloodCollectServ) {
        this.bloodCollectServ = bloodCollectServ;
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createBloodCollect(@Valid @RequestBody BloodCollectionDto bloodCollectDto) {
        APIResponse response = bloodCollectServ.createBloodColection(bloodCollectDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
