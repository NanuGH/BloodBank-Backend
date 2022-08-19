package cv.hernani.bloodbankprojectspring.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class CommonPersonAtributsModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false, unique = true, length = 10)
    private UUID id;

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

    @Column(name="insertion_date", nullable = false, updatable = false)
    private LocalDateTime insertionDate;

    @Column(name="update_date", nullable = false, updatable = false)
    private LocalDateTime updateDate;

    @Column(name="who_inserted", nullable = false, updatable = false)
    private String whoInserted; 

    @Column(name="who_updated", nullable = false, updatable = false)
    private String WhoUpdated;
    
}
