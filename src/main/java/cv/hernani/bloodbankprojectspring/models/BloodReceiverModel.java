package cv.hernani.bloodbankprojectspring.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tb_blood_receiver")
public class BloodReceiverModel extends PersonModel{

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_receiver", nullable = false, unique = true, length = 10)
    private UUID idReceiver;
    
}
