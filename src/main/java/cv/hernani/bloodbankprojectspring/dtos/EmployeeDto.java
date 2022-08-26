package cv.hernani.bloodbankprojectspring.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmployeeDto {

    private String pw;

    private String dmfunction;

    private String whoUpdated;
    
    @JsonProperty("Person")
    private PersonDto personDto;
}
