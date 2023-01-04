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

    @ManyToOne
    @JoinColumn(name = "fk_id_employee", nullable = false, unique = true)
    private EmployeeModel idEmployee;

    @ManyToOne
    @JoinColumn(name = "fk_id_sample", nullable = false, unique = true)
    private SampleModel idSample;

    @Column(name = "test_number", nullable = false, unique = true)
    private String testNumber;

    /* @Column(name = "blood_presure", nullable = false, length = 20)  
    private String bloodPresure; */

   /*  @Column(name = "weight", nullable = false, length = 20)
    private String weight; */

    @Column(name = "vdrl", nullable = false, length = 20)
    private Boolean vdrl;

    @Column(name = "dm_sample", nullable = false, length = 20)
    private Boolean hiv;

    @Column(name = "aghbs", nullable = false, length = 20)
    private Boolean aghbs;

    @Column(name = "hcv", nullable = false, length = 20)
    private Boolean hcv;

    @Column(name = "clinical_conc", nullable = false, length = 20)
    private String clinicalConc;

    @Column(name = "obs", nullable = false, length = 20)
    private String obs;
    
}
