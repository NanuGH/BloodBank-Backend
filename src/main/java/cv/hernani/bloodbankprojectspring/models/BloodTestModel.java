package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_blood_test")
public class BloodTestModel extends CommonAtributsModel {


    @Column(name = "id_blood_test", nullable = false, unique = true, length = 10)
    private String idBloodTest;

    @ManyToOne
    @JoinColumn(name = "fk_id_employee", nullable = false, unique = true)
    private EmployeeModel idEmployee;

    @ManyToOne
    @JoinColumn(name = "fk_id_sample", nullable = false, unique = true)
    private EmployeeModel idSample;

    @ManyToOne
    @JoinColumn(name = "fk_id_domain", nullable = false, unique = true)
    private DomainModel idDomain;

    @Column(name = "blood_presure", nullable = false, length = 20)
    private String bloodPresure;

    @Column(name = "weight", nullable = false, length = 20)
    private String weight;

    @Column(name = "hb", nullable = false, length = 20)
    private String hb;

    @Column(name = "vdrl", nullable = false, length = 20)
    private String vdrl;

    @Column(name = "dm_sample", nullable = false, length = 20)
    private String hiv;

    @Column(name = "aghbs", nullable = false, length = 20)
    private String aghbs;

    @Column(name = "hcv", nullable = false, length = 20)
    private String hcv;

    @Column(name = "clinical_conc", nullable = false, length = 20)
    private String clinicalConc;

    @Column(name = "obs", nullable = false, length = 20)
    private String obs;
    
}
