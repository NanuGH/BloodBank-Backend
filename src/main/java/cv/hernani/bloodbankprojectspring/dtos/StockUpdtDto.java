package cv.hernani.bloodbankprojectspring.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class StockUpdtDto {
    
    private Date expirationDate;

    private String dmCodeStockType;

    private String WhoUpdated;
}
