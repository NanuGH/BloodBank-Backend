package cv.hernani.bloodbankprojectspring.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_employee")
public class EmployeeModel extends CommonPersonAtributsModel{

    private static final long serialVersionUID = 1L;

    /*@Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_employee",nullable = false, unique = true, length = 10)
    private UUID idEmployee;*/

    @Column(name="dm_blood_group", nullable = false)
    private String dmBloodGroup;

    @Column(name="identif_number", nullable = false)
    private String identNumber;

    @Column(name="password", nullable = false)
    private String pw;

    @Column(name="function", nullable = false)
    private String function;

    
}
