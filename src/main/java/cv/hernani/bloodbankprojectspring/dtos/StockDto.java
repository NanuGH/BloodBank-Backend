package cv.hernani.bloodbankprojectspring.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;
import lombok.Data;

@Data
public class StockDto {
    
    @JsonProperty("BloodCollection")
    private BloodCollectionModel idcollection;
    
    private Date expirationDate;

    private String dmCodeStockType;
}
