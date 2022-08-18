package cv.hernani.bloodbankprojectspring.models;

//import java.util.UUID;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/
import javax.persistence.Table;

@Entity
@Table(name= "tb_blood_receiver")
public class BloodReceiverModel extends PersonModel{

    @OneToOne
    @JoinColumn(name = "fk_dm_typePerson")
    private PersonModel dmTypePerson;

    /*@Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_receiver", nullable = false, unique = true, length = 10)
    private UUID idReceiver;*/

    
    
}
