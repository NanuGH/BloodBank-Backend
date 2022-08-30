package cv.hernani.bloodbankprojectspring.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RejectionDto {

    private String dmCodeRejection;

    private String dmCodeDonation;
    
    @JsonProperty("Person")
    private PersonDto personDto;
}