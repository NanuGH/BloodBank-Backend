package cv.hernani.bloodbankprojectspring.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmployeeDto {

    private String pw;

    private String dmfunction;
    
    @JsonProperty("Person")
    private PersonDto personDto;
}
