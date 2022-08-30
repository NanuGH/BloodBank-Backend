package cv.hernani.bloodbankprojectspring.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmployeeDto {

    private String pw;

    private String dmFunction;

    private String identNumber;
    
    @JsonProperty("Person")
    private PersonDto personDto;
}
