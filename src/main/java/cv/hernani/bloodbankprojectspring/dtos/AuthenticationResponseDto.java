package cv.hernani.bloodbankprojectspring.dtos;

import java.util.ArrayList;
import java.util.UUID;

import lombok.Data;

@Data
public class AuthenticationResponseDto {

    private String roles;
    private String email;
    private String name;
    private UUID idEmployee;
    private ArrayList<String> menu;

}
