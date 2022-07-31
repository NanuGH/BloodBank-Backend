package cv.hernani.bloodbankprojectspring.models;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_person")
public class PersonModel extends CommonAtributsModel{

    private static final long serialVersionUID = 1L;

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_person",nullable = false, unique = true, length = 10)
    private UUID idPerson;

    @Column(name="dm_type_person", nullable = false, length = 10)
    private String dmTypePerson;

    @Column(name="name_person", nullable = false, length = 10)
    private String namePerson;

    @Column(name="surname_person", nullable = false, length = 10)
    private String surnamePerson;

    @Column(name="dm_doc_ident", nullable = false, length = 15)
    private String dmDocIdent;

    @Column(name="birthday", nullable = false)
    private DateTimeFormat birthday;

    @Column(name="picture_person", nullable = true)
    private String picturePerson;

    @Column(name="dm_sex-person", nullable = false, length = 1)
    private String dmSex;

    @Column(name="dm_home_address", nullable = false, length = 10)
    private String dmHomeAdd;

    @Column(name="job_address", nullable = true, length = 10)
    private String jobAddress;

    @Column(name="profession", nullable = true, length = 10)
    private String profession;

    @Column(name="grade", nullable = true, length = 10)
    private String grade;//escolaridade

    public UUID getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
    }

    public String getDmTypePerson() {
        return dmTypePerson;
    }

    public void setDmTypePerson(String dmTypePerson) {
        this.dmTypePerson = dmTypePerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getSurnamePerson() {
        return surnamePerson;
    }

    public void setSurnamePerson(String surnamePerson) {
        this.surnamePerson = surnamePerson;
    }

    public String getDmDocIdent() {
        return dmDocIdent;
    }

    public void setDmDocIdent(String dmDocIdent) {
        this.dmDocIdent = dmDocIdent;
    }

    public DateTimeFormat getBirthday() {
        return birthday;
    }

    public void setBirthday(DateTimeFormat birthday) {
        this.birthday = birthday;
    }

    public String getPicturePerson() {
        return picturePerson;
    }

    public void setPicturePerson(String picturePerson) {
        this.picturePerson = picturePerson;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public String getDmSex() {
        return dmSex;
    }

    public void setDmSex(String dmSex) {
        this.dmSex = dmSex;
    }

    public String getDmHomeAdd() {
        return dmHomeAdd;
    }

    public void setDmHomeAdd(String dmHomeAdd) {
        this.dmHomeAdd = dmHomeAdd;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


}