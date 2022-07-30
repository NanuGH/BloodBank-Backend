package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.Table;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "tb_rejection")
public class RejectionModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_rejection",nullable = false, unique = true, length = 10)
    private UUID idReject;

    @Column(name="id_person",nullable = false, unique = true, length = 10)
    private UUID idPerson;

    @Column(name="dm_rejection",nullable = false, unique = true, length = 10)
    private UUID dmReject;

    @Column(name="dm_donation_type",nullable = false, unique = true, length = 10)
    private UUID dmDonaType;

}
