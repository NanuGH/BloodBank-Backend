package cv.hernani.bloodbankprojectspring.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cv.hernani.bloodbankprojectspring.dtos.DomainDto;
import cv.hernani.bloodbankprojectspring.service.DomainService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(path = "/domain")
public class DomainController {
    
    @Autowired
    private final DomainService domainService;

    public DomainController(DomainService domainService) {
        this.domainService = domainService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createDomain(@Valid @RequestBody DomainDto domainDto) {
        APIResponse response = domainService.createDomain(domainDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping()
    public ResponseEntity<Object> getDomain() {
        APIResponse response = domainService.getDomain();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteDomain(@PathVariable("id") UUID id) {
        domainService.deleteDomain(id);
        return new ResponseEntity<>("Domain deleted successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<Object> deletDomain(@PathVariable("id") UUID id){
        domainService.deletDomain(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
