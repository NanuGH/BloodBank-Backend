package cv.hernani.bloodbankprojectspring.models;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tb_person_rejected")
public class PersonRejectedModel extends CommonAtributsModel {

    @ManyToOne
    @JoinColumn(name="fk_id_person", nullable = false, unique = false)
    private PersonModel idPerson;

    @Column(name="dm_rejectionCode", nullable = false)
    private String rejectionCode;
    
}
