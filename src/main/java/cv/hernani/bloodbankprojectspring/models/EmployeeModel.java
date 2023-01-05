package cv.hernani.bloodbankprojectspring.models;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "tb_employee")
public class EmployeeModel extends CommonAtributsModel{

    @ManyToOne
    @JoinColumn(name="fk_id_person", nullable = false, unique = false)
    private PersonModel idPerson;

    @ManyToOne
    @JoinColumn(name="fk_role_code", nullable = true)
    private RolesModel role;

    @Column(name="identifNumber", nullable = true, length=15 )
    private String identifNumber;

    @Column(name="password", nullable = true, length=100)
    private String pw;

    @Column(name="dm_function", nullable = true, length=15)
    private String dmfunction;

    @Column(name="email", nullable = true)
    private String  email;  

}
