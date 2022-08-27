package cv.hernani.bloodbankprojectspring.dtos;

import lombok.Data;

@Data
public class StockDto {
    
    @JsonProperty("BloodCollection")
    private BloodCollectionModel idcollection;
    
    private Date expirationDate;

    private String dmCodeStockType;
}
