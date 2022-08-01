package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_blood_test")
public class BloodTestModel extends CommonAtributsModel {


    @Column(name = "id_blood_test", nullable = false, unique = true, length = 10)
    private String idEmployee;

    @Column(name = "id_sample", nullable = false, unique = true, length = 10)
    private String idSample;

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
