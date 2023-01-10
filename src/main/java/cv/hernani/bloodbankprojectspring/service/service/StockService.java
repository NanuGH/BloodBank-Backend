package cv.hernani.bloodbankprojectspring.service.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.StockDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface StockService {

    public APIResponse createStock(StockDto stockDto, UUID idCollect, UUID idEmpl);
    public APIResponse getAllStock();
    public APIResponse getStockById(UUID id);
    public APIResponse getStockByDmCodeStockType(String dmCodeStockType);
    public APIResponse deleteStockById(UUID id);
    public APIResponse updateStock(UUID id,StockDto stockUpdtDto);
    public APIResponse disableStock(UUID id,StockDto stockUpdtDto);
    public APIResponse findStockByOptionals(String collectionNumber);
    public APIResponse changeStockType(UUID id);
    
}