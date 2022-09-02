package cv.hernani.bloodbankprojectspring.dtos;

import lombok.Data;

@Data
public class DonationRejectedDto {
    private String rejectionCollectCode;
    private String whoInserted;
    private String whoUpdated;
}
