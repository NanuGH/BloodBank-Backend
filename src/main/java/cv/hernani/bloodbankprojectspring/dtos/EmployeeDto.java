package cv.hernani.bloodbankprojectspring.dtos;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmployeeDto {

    private String password;

    private String dmfunction;

    //private String identifNumber;
    
    @JsonProperty("Person")
    private PersonDto personDto;

    @Email
    private String email;
}
