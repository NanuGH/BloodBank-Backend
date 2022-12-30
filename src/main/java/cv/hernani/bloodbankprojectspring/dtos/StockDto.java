package cv.hernani.bloodbankprojectspring.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class StockDto {
    private Date expirationDate;
    private String dmCodeStockType;
    private String whoInserted;
    private String whoUpdated;
    private String dmDisabledCode;
    private boolean dmStatus;
}
