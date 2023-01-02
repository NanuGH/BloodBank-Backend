package cv.hernani.bloodbankprojectspring.models;

import java.util.Date;

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

    @Column(name="collection_number", nullable = false)
    private String collectionNumber;

    @Column(name="blood_type", nullable = true)
    private String bloodType;

    @Column(name="expiration_date", nullable = false)
    private Date expirationDate;
   
}
