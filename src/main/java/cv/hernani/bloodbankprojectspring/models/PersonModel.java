package cv.hernani.bloodbankprojectspring.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_person")
public class PersonModel extends CommonAtributsModel{

    @Column(name="dm_type_person", nullable = false, length = 10)
    private String dmTypePerson;

    @Column(name="name_person", nullable = false, length = 10)
    private String namePerson;

    @Column(name="surname_person", nullable = false, length = 10)
    private String surnamePerson;

    @Column(name="dm_doc_ident", nullable = false, length = 15)
    private String dmDocIdent;

    @Column(name="birthday", nullable = false)
    private LocalDate birthday;

    @Column(name="picture_person", nullable = true)
    private String picturePerson;

    @Column(name="dm_sex_person", nullable = false, length = 1)
    private String dmSex;

    @Column(name="dm_home_address", nullable = false, length = 10)
    private String dmHomeAdd;

    @Column(name="job_address", nullable = true, length = 10)
    private String jobAddress;

    @Column(name="profession", nullable = true, length = 10)
    private String profession;

    @Column(name="grade", nullable = true, length = 10)
    private String grade;//escolaridade
}