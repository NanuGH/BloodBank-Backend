package cv.hernani.bloodbankprojectspring.models;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_disablement")
public class DisablementModel extends CommonAtributsModel {

    private static final long serialVersionUID = 1L;

    @Column(name="id_disabled",nullable = false, unique = true, length = 10)
    private UUID idDisabled;

    @ManyToOne
    @JoinColumn(name = "fk_id_stock", nullable = false, unique = true)
    private StockModel id;

    @ManyToOne
    @JoinColumn(name = "fk_id_employee", nullable = false, unique = true)
    private EmployeeModel idEmployee;

    @Column(name="dm_code_disabled",nullable = false, unique = true)
    private String dmCodeDisabled;   


}
