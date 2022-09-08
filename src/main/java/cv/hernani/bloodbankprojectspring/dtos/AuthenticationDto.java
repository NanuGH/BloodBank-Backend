package cv.hernani.bloodbankprojectspring.dtos;

import javax.validation.constraints.Email;

import lombok.Data;

@Data
public class AuthenticationDto {

    @Email
    private String email;
    private String pw;
}
