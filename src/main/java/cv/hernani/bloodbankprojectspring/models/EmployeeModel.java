package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "tb_employee")
public class EmployeeModel extends CommonPersonAtributsModel{

    private static final long serialVersionUID = 1L;

    @Column(name="dm_blood_group", nullable = false, length = 2)
    private String dmBloodCode;

    @Column(name="identif_number", nullable = false, length=10 )
    private String identNumber;

    @Column(name="password", nullable = false, length=10)
    private String pw;

    @Column(name="dm_function", nullable = false, length=5)
    private String dmfunction;

    
}
