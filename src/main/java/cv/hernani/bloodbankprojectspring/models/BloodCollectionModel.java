package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="tb_blood_collection")
public class BloodCollectionModel extends CommonAtributsModel{

    @ManyToOne
    @JoinColumn(name="fk_id_donor", nullable = false, unique = false)
    private PersonModel idPerson;

    @ManyToOne
    @JoinColumn(name="fk_id_employee", nullable = false, unique = false)
    private EmployeeModel idEmployee;

    @Column(name="quantidade", nullable = false)
    private String qtdde;

    @Column(name="external_collection", nullable = false)
    private String externCollection;

    

    
}
