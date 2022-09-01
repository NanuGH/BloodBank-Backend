package cv.hernani.bloodbankprojectspring.dtos;
import lombok.Data;

@Data
public class PersonRejectedDto {
    private String rejectionCode;
    private String whoInserted;
    private String whoUpdated;
}
