package cv.hernani.bloodbankprojectspring.dtos;

import lombok.Data;

@Data
public class BloodCollectionDto{
    
    private String qtdde;

    private String externCollection;

    private String whoUpdated;

    private String whoInserted;

}
