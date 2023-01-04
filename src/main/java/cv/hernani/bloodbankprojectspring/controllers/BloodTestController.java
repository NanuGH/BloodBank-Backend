package cv.hernani.bloodbankprojectspring.controllers;

import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import cv.hernani.bloodbankprojectspring.dtos.BloodTestDto;
import cv.hernani.bloodbankprojectspring.service.service.BloodTestService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/bloodtest")
public class BloodTestController {

    @Autowired
    private final BloodTestService bloodTestServ;

    public BloodTestController(BloodTestService bloodTestServ) {
        this.bloodTestServ = bloodTestServ;
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{idFunc}/{idSample}")
    public ResponseEntity<Object> createBloodTest(@Valid @RequestBody BloodTestDto bloodTestDto,
                                                   @PathVariable("idFunc") UUID idFunc,
                                                   @PathVariable("idSample") UUID idSample) {
        APIResponse response = bloodTestServ.createBloodTest(bloodTestDto, idFunc, idSample);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object>getAllTest(){
        APIResponse response = bloodTestServ.getAllBloodTest();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value ="/test/{testNumber}")
    public ResponseEntity<Object> getTestByNumber(@PathVariable("testNumber") String testNumber) {
        APIResponse response = bloodTestServ.getTestByTestNumber(testNumber);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Object> getTestById(@PathVariable("id") UUID id) {
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
