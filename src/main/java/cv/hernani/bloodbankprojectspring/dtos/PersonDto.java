package cv.hernani.bloodbankprojectspring.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/*get and set */
@Data
public class PersonDto { 
    /* para validar os campos q o cliente envia */
    @NotBlank
    @Size(max = 10)
    private String dmTypePerson;

    @NotBlank
    @Size(max = 10)
    private String namePerson;

    @NotBlank
    @Size(max = 10)
    private String surnamePerson;

    @NotBlank
    @Size(max = 10)
    private String dmDocIdent;

    @NotBlank
    @Size(max = 10)
    private DateTimeFormat birthday;

    @NotBlank
    @Size(max = 10)
    private String picturePerson;

    @NotBlank
    @Size(max = 10)
    private String dmSex;

    @NotBlank
    @Size(max = 10)
    private String dmHomeAdd;

    @Size(max = 10)
    private String jobAddress;

    @Size(max = 10)
    private String profession;

    @Size(max = 10)
    private String grade;//escolaridade
}
