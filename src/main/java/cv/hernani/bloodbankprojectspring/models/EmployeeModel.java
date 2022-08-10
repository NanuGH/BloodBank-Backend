package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "tb_blood_donor")
public class EmployeeModel extends CommonPersonAtributsModel{

    private static final long serialVersionUID = 1L;

    @Column(name="dm_blood_group", nullable = false)
    private String dmBloodGroup;

    @Column(name="identif_number", nullable = false)
    private String identNumber;

    @Column(name="password", nullable = false)
    private String pw;

    @Column(name="function", nullable = false)
    private String function;

    
}
