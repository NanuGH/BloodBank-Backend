package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "tb_blood_receiver")
public class BloodReceiverModel extends CommonAtributsModel{

    @ManyToOne
    @JoinColumn(name="fk_id_person", nullable = false)
    private PersonModel idPerson;

    @ManyToOne
    @JoinColumn(name="fk_id_employee", nullable = false)
    private EmployeeModel idEmployee;

    @ManyToOne
    @JoinColumn(name="fk_id_bloodCollection", nullable = false)
    private BloodCollectionModel idBloodCollect;

    @Column(name="abo_rh", nullable = true)
    private String  abo_rh;

    @Column(name=" mother_abo_rh", nullable = true)
    private String mother_abo_rh;

    
    
}
