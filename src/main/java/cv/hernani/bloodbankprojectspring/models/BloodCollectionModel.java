package cv.hernani.bloodbankprojectspring.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_blood_collection")
public class BloodCollectionModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_collection", nullable = false, unique = false, length = 10)
    private String idCollection;

    @Column(name="id_donor", nullable = false, unique = false, length = 10)
    private String idDonor;

    @Column(name="id_employee", nullable = false, unique = false, length = 10)
    private String idEmployee;

    @Column(name="quantidade", nullable = false)
    private String qtdde;

    @Column(name="external_collection", nullable = false)
    private String externCollection;
    
}
