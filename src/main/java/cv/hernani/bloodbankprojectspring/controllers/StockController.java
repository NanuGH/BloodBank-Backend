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

import cv.hernani.bloodbankprojectspring.dtos.StockDto;
import cv.hernani.bloodbankprojectspring.dtos.StockUpdtDto;
import cv.hernani.bloodbankprojectspring.service.StockService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/stock")
public class StockController {

    @Autowired
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value="/{id}")
    public ResponseEntity<Object> createStock(@Valid @RequestBody StockDto stockDto, @PathVariable("id") UUID id ) {
        APIResponse response = stockService.createStock(stockDto,id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object>getAllStock(){
        APIResponse response = stockService.getAllStock();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getStocktById(@PathVariable(value = "id") UUID id) {
        APIResponse response = stockService.getStockById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStock(@PathVariable(value = "id") UUID id){
        APIResponse response = stockService.deleteStockById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStock(@PathVariable(value = "id") UUID id, @RequestBody @Valid StockUpdtDto stockUpdtDto){        
        APIResponse response = stockService.updateStock(id,stockUpdtDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}