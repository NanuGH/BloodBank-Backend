package cv.hernani.bloodbankprojectspring.models;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_employee")
public class EmployeeModel extends CommonAtributsModel{

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="fk_id_person", nullable = false, unique = false)
    private PersonModel idPerson;
    
    @JoinColumn(name="insertion_date", nullable = false, unique = false)
    private LocalDateTime insertionDate;

    @JoinColumn(name="update_date", nullable = false, unique = false)
    private LocalDateTime updateDate;   

    /*@Column(name="dm_blood_code", nullable = true, length = 2)
    private String dmBloodCode;*/

    @Column(name="identifNumber", nullable = true, length=15 )
    private String identifNumber;

    @Column(name="password", nullable = true, length=15)
    private String pw;

    @Column(name="dm_function", nullable = true, length=15)
    private String dmfunction;

    
}
