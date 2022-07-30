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
@Table(name="tb_sample")
public class SampleModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sample", nullable = false, unique = true, length = 10)
    private UUID idSample;
    
    @Column(name = "id_employee", nullable = false, unique = true, length = 10)
    private UUID idEmployee;//foreignkey

    @Column(name = "id_collectiion", nullable = false, unique = true, length = 10)
    private UUID idCollection;//foreignkey

    @Column(name = "dm_sample", nullable = false)
    private UUID dmSample;//foreignkey
}
