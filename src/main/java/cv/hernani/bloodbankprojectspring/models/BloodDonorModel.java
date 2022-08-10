package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_blood_donor")
public class BloodDonorModel extends CommonPersonAtributsModel {

    private static final long serialVersionUID = 1L;

   /*@Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_donor",nullable = false, unique = true, length = 10)
    private UUID idDoner;*/

    @Column(name="dm_blood_group", nullable = false)
    private String dmBloodGroup;

    @Column(name="dm_type_donor", nullable = false)
    private String dmTypeDonor;

    @Column(name="personal_bckgrd", nullable = false)
    private String personalBackground;//antecedentes pessoais

    @Column(name="clinical_exam", nullable = false)
    private String clinicalExam;

    @Column(name="physical_exam", nullable = false)
    private String physicalExam;

    @Column(name="kell", nullable = false)
    private String kell;

    @Column(name="summoned", nullable = false)
    private boolean summoned;//convocado

    @Column(name="cel_falcif", nullable = true)
    private boolean celFalcif;

    @Column(name="dm_phenotype", nullable = true)
    private String Phenotype;//escolaridade

    @Column(name="dm_hemolisina", nullable = false)
    private String dmHemolisina;
    
}
