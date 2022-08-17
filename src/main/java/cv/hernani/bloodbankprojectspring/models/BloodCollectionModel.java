package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_blood_collection")
public class BloodCollectionModel extends CommonPersonAtributsModel{

    @Column(name="id_collection", nullable = false, unique = false, length = 10)
    private String id_collection;

    @ManyToOne
    @JoinColumn(name="fk_id_donor", nullable = false, unique = false)
    private BloodDonorModel idDonor;

    @ManyToOne
    @JoinColumn(name="fk_id_employee", nullable = false, unique = false)
    private EmployeeModel idEmployee;

    @Column(name="quantidade", nullable = false)
    private String qtdde;

    @Column(name="external_collection", nullable = false)
    private String externCollection;
    
}
