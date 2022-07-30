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
@Table(name = "tb_common_atributs")
public class TransferMonitoringModel implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_common",nullable = false, unique = true, length = 10)
    private UUID id;

    @Column(name="id_employee",nullable = false, unique = true, length = 10)
    private UUID idEmployee;

    @Column(name="id_transfusion",nullable = false, unique = true, length = 10)
    private UUID id_transfusion;

    @Column(name="blood_pressure", nullable = false)
    private String bloodPressure;

    @Column(name="pulsation", nullable = false)
    private String pulsation;

    @Column(name="temperature", nullable = false)
    private String tmprtre;


}
