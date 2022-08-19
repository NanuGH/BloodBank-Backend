package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@Table(name = "tb_rejection")
public class RejectionModel extends CommonAtributsModel{

    @ManyToOne
    @JoinColumn(name = "fk_id_person", nullable = false, unique = true)
    private PersonModel id;

    @Column(name="dm_code_rejection",nullable = false, unique = true)
    private String dmCodeRejection;

    @Column(name="dm_code_donation",nullable = false, unique = true, length = 10)
    private String dmCodeDonation;

}
