package cv.hernani.bloodbankprojectspring.controllers;

import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cv.hernani.bloodbankprojectspring.dtos.BloodCollectionDto;
import cv.hernani.bloodbankprojectspring.service.BloodCollectionService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/bloodcollection")
public class BloodCollectionController {
    
    @Autowired
    private final BloodCollectionService bloodCollectServ;

    public BloodCollectionController(BloodCollectionService bloodCollectServ) {
        this.bloodCollectServ = bloodCollectServ;
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{idFunc}/{idPessoa}")
    public ResponseEntity<Object> createBloodCollect(@Valid @RequestBody BloodCollectionDto bloodCollectDto, @PathVariable("idFunc") UUID idFunc, @PathVariable("idPessoa") UUID idPessoa) {
        APIResponse response = bloodCollectServ.createBloodCollection(bloodCollectDto,idFunc,idPessoa);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object>getAllBloodCollect(){
        APIResponse response = bloodCollectServ.getAllBloodCollection();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Object> getBloodCollectById(@PathVariable("id") UUID id) {
        APIResponse response = bloodCollectServ.getBloodCollectById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Object> deleteBloodCollect(@PathVariable("id") UUID id){
        APIResponse response = bloodCollectServ.delBloodCollection(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBloodColeect(@PathVariable(value = "id") UUID id,@RequestBody @Valid BloodCollectionDto bloodCollectionDto){        
        APIResponse response = bloodCollectServ.updtBloodCollection(id,bloodCollectionDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
                                              
}
