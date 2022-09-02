package cv.hernani.bloodbankprojectspring.models;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tb_donation_rejected")
public class DonationRejectedModel extends CommonAtributsModel {

    @ManyToOne
    @JoinColumn(name="fk_id_bloodCollect", nullable = false, unique = false)
    private BloodCollectionModel idBloodCollect;

    @Column(name="dm_rejectionCollectCode", nullable = false)
    private String rejectionCollectCode;
}
