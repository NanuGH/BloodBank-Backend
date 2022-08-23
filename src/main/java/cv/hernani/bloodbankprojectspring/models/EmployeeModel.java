package cv.hernani.bloodbankprojectspring.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_employee")
public class EmployeeModel extends CommonPersonAtributsModel{

    private static final long serialVersionUID = 1L;

    @Column(name="dm_blood_code", nullable = true, length = 2)
    private String dmBloodCode;

    @Column(name="identifNumber", nullable = true, length=15 )
    private String identifNumber;

    @Column(name="password", nullable = true, length=15)
    private String pw;

    @Column(name="dm_function", nullable = true, length=15)
    private String dmfunction;

    
}
