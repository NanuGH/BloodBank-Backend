package cv.hernani.bloodbankprojectspring.models;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_disablement")
public class DisablementModel extends CommonAtributsModel {

    private static final long serialVersionUID = 1L;

    @Column(name="id_stock",nullable = false, unique = true, length = 10)
    private UUID idStock;

    @Column(name="id_employee",nullable = false, unique = true, length = 10)
    private UUID idEmployee;

    @Column(name="dm_disablement_type",nullable = false, unique = true, length = 10)
    private UUID dmDisabType;   


}
