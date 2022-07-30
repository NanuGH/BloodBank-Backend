package cv.hernani.bloodbankprojectspring.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_transfusion")
public class TransfusionModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_transfusion",nullable = false, unique = true, length = 10)
    private UUID idTransf;

    @Column(name="id_receiver",nullable = false, unique = true, length = 10)
    private UUID idReceiver;

    @Column(name="id_employee",nullable = false, unique = true, length = 10)
    private UUID idEmployee;

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
