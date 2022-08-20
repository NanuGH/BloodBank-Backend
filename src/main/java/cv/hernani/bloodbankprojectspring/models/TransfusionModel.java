package cv.hernani.bloodbankprojectspring.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_transfusion")
public class TransfusionModel extends CommonAtributsModel {

    /*@Column(name="id_receiver",nullable = false, unique = true, length = 10)
    private UUID idTransfusion;*/

    @ManyToOne
    @JoinColumn(name = "fk_id_collection", nullable = false, unique = true)
    private BloodCollectionModel idCollection;
    
    @ManyToOne
    @JoinColumn(name="fk_id_employee",nullable = false, unique = true)
    private EmployeeModel idEmployee;

    @ManyToOne
    @JoinColumn(name="fk_id_receiver",nullable = false, unique = true)
    private BloodReceiverModel idReceiver;

    @Column(name="suspended", nullable = false)
    private boolean suspended;

    @Column(name="suspension_date", nullable = false)
    private String suspDate;

    @Column(name="suspension_reason", nullable = false)
    private boolean suspReason;

    @Column(name="transfer_restarted", nullable = false)
    private String transfRest; 
    
    @Column(name="transf_restart_date", nullable = false)
    private String transfRestDate;

    @Column(name="obs_transf_restarted", nullable = false)
    private String obsTransfRest;

    @Column(name="drip", nullable = false)
    private String drip;//gotejo

    @Column(name="nursery", nullable = false)
    private String nursery;

    @Column(name="room", nullable = false)
    private String room;

    @Column(name="bed", nullable = false)
    private String bed;

    @Column(name="dm_param_changed", nullable = false)
    private String dmParamChanged;

    @Column(name="dm_transf_symptom", nullable = false)
    private String dmTranSymptom;

    @Column(name="applied_therapy", nullable = false)
    private String appliedTherapy;
}
