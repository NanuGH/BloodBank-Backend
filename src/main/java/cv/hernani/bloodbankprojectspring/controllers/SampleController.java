package cv.hernani.bloodbankprojectspring.controllers;

import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import org.springframework.web.bind.annotation.*;

import cv.hernani.bloodbankprojectspring.dtos.SampleDto;
import cv.hernani.bloodbankprojectspring.dtos.StockDto;
import cv.hernani.bloodbankprojectspring.service.service.SampleService;
import cv.hernani.bloodbankprojectspring.service.service.StockService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/sample")
public class SampleController {

    @Autowired
    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value="/{idCollection}/{idEmpl}")
    public ResponseEntity<Object> createStock(@Valid @RequestBody SampleDto sampleDto,
                                              @PathVariable("idCollection") UUID idCollection,
                                              @PathVariable("idEmpl") UUID idEmpl ) {
        APIResponse response = sampleService.createSample(sampleDto,idCollection,idEmpl);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object>getAllSample(){
        APIResponse response = sampleService.getAllSample();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSampleById(@PathVariable(value = "id") UUID id) {
        APIResponse response = sampleService.getSampleById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSample(@PathVariable(value = "id") UUID id, @RequestBody @Valid SampleDto sampleDto){        
        APIResponse response = sampleService.updateSample(id, sampleDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStock(@PathVariable(value = "id") UUID id){
        APIResponse response = stockService.deleteStockById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
 
    @PutMapping("/disablestock/{id}")
    public ResponseEntity<Object> disableStock(@PathVariable(value = "id") UUID id, @RequestBody @Valid StockDto stockDto){        
        APIResponse response = stockService.disableStock(id,stockDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getStockOpts/{numCollect}")
    public ResponseEntity<Object> getStockOptional(@PathVariable(value = "numCollect") String numCollect) {
        APIResponse response = stockService.findStockByOptionals(numCollect);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }  

    @GetMapping("stockType/{dmCodeStockType}")
    public ResponseEntity<Object> getStocktByStockType(@PathVariable(value = "dmCodeStockType") String dmCodeStockType) {
        APIResponse response = stockService.getStockByDmCodeStockType(dmCodeStockType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    */
}