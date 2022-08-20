package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_transfer_monitoring")
public class TransferMonitoringModel extends CommonAtributsModel {

    @ManyToOne
    @JoinColumn(name="fk_id_employee",nullable = false, unique = true)
    private EmployeeModel idEmployee;

    @ManyToOne
    @JoinColumn(name="fk_id_transfusion",nullable = false, unique = true)
    private TransfusionModel idTransfusion;

    @Column(name="blood_pressure", nullable = false)
    private String bloodPressure;

    @Column(name="pulsation", nullable = false)
    private String pulsation;

    @Column(name="temperature", nullable = false)
    private String temprature;


}
