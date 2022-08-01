package cv.hernani.bloodbankprojectspring.models;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_sample")
public class SampleModel extends CommonAtributsModel {

    private static final long serialVersionUID = 1L;

    @Column(name = "id_employee", nullable = false, unique = true, length = 10)
    private UUID idEmployee;//foreignkey

    @Column(name = "id_collectiion", nullable = false, unique = true, length = 10)
    private UUID idCollection;//foreignkey

    @Column(name = "dm_sample", nullable = false)
    private UUID dmSample;//foreignkey
}
