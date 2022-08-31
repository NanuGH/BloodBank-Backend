package cv.hernani.bloodbankprojectspring.dtos;

import lombok.Data;

@Data
public class BloodReceiverDto {

    private String  abo_rh;
    private String mother_abo_rh;
    private String whoInserted; 
    private String whoUpdated;
    
}
