package cv.hernani.bloodbankprojectspring.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class BloodCollectionDto{
    
    private String qtdde;

    private String collectionNumber;

    private String externCollection;

    private String whoUpdated;

    private String whoInserted;

    private Date expirationDate;

}
