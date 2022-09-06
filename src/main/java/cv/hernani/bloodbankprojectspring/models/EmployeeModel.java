package cv.hernani.bloodbankprojectspring.models;
import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_employee")
public class EmployeeModel extends CommonAtributsModel{

    @ManyToOne
    @JoinColumn(name="fk_id_person", nullable = false, unique = false)
    private PersonModel idPerson;
    
    @Column(name="insertion_date", nullable = true) 
    @CreationTimestamp //sem necessidade de fazer set na serviço
    private LocalDateTime insertionDate;

    @Column(name="update_date", nullable = true)
    @UpdateTimestamp
    private LocalDateTime updateDate;
    
    /*@Column(name="dm_blood_code", nullable = true, length = 2)
    private String dmBloodCode;*/

    @Column(name="identifNumber", nullable = true, length=15 )
    private String identifNumber;

    @Column(name="password", nullable = true, length=100)
    private String pw;

    @Column(name="dm_function", nullable = true, length=15)
    private String dmFunction;

    
}
