package cv.hernani.bloodbankprojectspring.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class SampleDto {
    private Date expirationDate;
    private String sampleNumber;

    private String whoInserted;
    private String whoUpdated;
    private String dmDisabledCode;
    private boolean dmStatus;
}
