package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_blood_collection")
public class BloodCollectionModel extends CommonAtributsModel{


    @Column(name="id_donor", nullable = false, unique = false, length = 10)
    private String idDonor;

    @Column(name="id_employee", nullable = false, unique = false, length = 10)
    private String idEmployee;

    @Column(name="quantidade", nullable = false)
    private String qtdde;

    @Column(name="external_collection", nullable = false)
    private String externCollection;
    
}
