package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.Table;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Table(name = "tb_rejection")
public class RejectionModel extends CommonAtributsModel{

    @Column(name="id_person",nullable = false, unique = true, length = 10)
    private UUID idPerson;

    @Column(name="dm_rejection",nullable = false, unique = true, length = 10)
    private UUID dmReject;

    @Column(name="dm_donation_type",nullable = false, unique = true, length = 10)
    private UUID dmDonaType;

}
