package cv.hernani.bloodbankprojectspring.dtos;

import java.time.LocalDate;

//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PersonDto { // para validar os campos q o cliente envia    

    //@NotBlank
    @Size(max = 10)
    private String namePerson;

    //@NotBlank
    @Size(max = 10)
    private String surnamePerson;

    //@Size(max = 3)
    private String dmBloodCode;

    //@NotBlank
    //@Size(max = 15)
    private String dmDocIdent;

    //@NotBlank
    private LocalDate birthday;

    //@NotBlank
    private String picturePerson;

    //@NotBlank
   // @Size(max = 1)
    private String dmSex;

    //@NotBlank
    @Size(max = 20)
    private String dmHomeAdd;

    @Size(max = 20)
    private String jobAddress;

    @Size(max = 15)
    private String profession;

    @Size(max = 15)
    private String grade;

    @Size(max = 15)
    private String whoInserted;

    @Size(max = 15)
    private String whoUpdated;

    private String status="true";

    private String email;


}
