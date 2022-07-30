package cv.hernani.bloodbankprojectspring.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "tb_common_atrib")
public class CommonAtributsModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="insertion_date", nullable = false, updatable = false)
    private DateTimeFormat insertionData;

    @Column(name="update_date", nullable = false, updatable = false)
    private DateTimeFormat updateDate;

    //id funcionario???????????????
    @Column(name="who_inserted", nullable = false, updatable = false)
    private String whoInserted; 

    @Column(name="who_updated", nullable = false, updatable = false)
    private String WhoUpdated;
    
}
