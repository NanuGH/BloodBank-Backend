package cv.hernani.bloodbankprojectspring.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "tb_common_atrib")
public class CommonAtributsModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="insertion_date", nullable = false, updatable = false)
    private LocalDateTime insertionDate;

    @Column(name="update_date", nullable = false, updatable = false)
    private LocalDateTime updateDate;

    //id funcionario???????????????
    @Column(name="who_inserted", nullable = false, updatable = false)
    private String whoInserted; 

    @Column(name="who_updated", nullable = false, updatable = false)
    private String WhoUpdated;
    
}
