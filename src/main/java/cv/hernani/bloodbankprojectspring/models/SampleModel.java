package cv.hernani.bloodbankprojectspring.models;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_sample")
public class SampleModel extends CommonAtributsModel {

    private static final long serialVersionUID = 1L;

    @Column(name = "id_sample", nullable = false, unique = true, length = 10)
    private UUID idSample;

    @ManyToOne
    @JoinColumn(name="fk_id_employee", nullable = false, unique = false)
    private EmployeeModel idEmployee;

    @ManyToOne
    @JoinColumn(name="fk_id_collection", nullable = false, unique = false)
    private BloodCollectionModel idCollection;

    @Column(name = "dm_sample", nullable = false)
    private UUID dmSample;//foreignkey
}
