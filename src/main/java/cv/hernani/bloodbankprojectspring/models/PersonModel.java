package cv.hernani.bloodbankprojectspring.models;

import java.util.Date;
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

    public UUID getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(UUID idPerson) {
        this.idPerson = idPerson;
    }

    @Column(name="dm_type_person", nullable = false, length = 15)
    private String dmTypePerson;

    public String getDmTypePerson() {
        return dmTypePerson;
    }

    public void setDmTypePerson(String dmTypePerson) {
        this.dmTypePerson = dmTypePerson;
    }

    @Column(name="name_person", nullable = false, length = 10)
    private String namePerson;

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    @Column(name="surname_person", nullable = false, length = 10)
    private String surnamePerson;

    public String getSurnamePerson() {
        return surnamePerson;
    }

    public void setSurnamePerson(String surnamePerson) {
        this.surnamePerson = surnamePerson;
    }

    @Column(name="dm_doc_ident", nullable = false, length = 15)
    private String dmDocIdent;

    public String getDmDocIdent() {
        return dmDocIdent;
    }

    public void setDmDocIdent(String dmDocIdent) {
        this.dmDocIdent = dmDocIdent;
    }

    @Column(name="birthday", nullable = false)
    private DateTimeFormat birthday;

    public DateTimeFormat getBirthday() {
        return birthday;
    }

    public void setBirthday(DateTimeFormat birthday) {
        this.birthday = birthday;
    }

    @Column(name="picture_person", nullable = true)
    private String picturePerson;

    public String getPicturePerson() {
        return picturePerson;
    }

    public void setPicturePerson(String picturePerson) {
        this.picturePerson = picturePerson;
    }

    @Column(name="dm_sex-person", nullable = false, length = 1)
    private String dmSex;

    public String getDmSex() {
        return dmSex;
    }

    public void setDmSex(String dmSex) {
        this.dmSex = dmSex;
    }

    @Column(name="dm_home_address", nullable = false, length = 10)
    private String dmHomeAdd;

    public String getDmHomeAdd() {
        return dmHomeAdd;
    }

    public void setDmHomeAdd(String dmHomeAdd) {
        this.dmHomeAdd = dmHomeAdd;
    }

    @Column(name="job_address", nullable = false, length = 10)
    private String jobAddress;

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    @Column(name="profession", nullable = true, length = 10)
    private String profession;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Column(name="grade", nullable = true, length = 10)
    private String grade;//escolaridade

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    

    
}