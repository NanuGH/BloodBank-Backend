package cv.hernani.bloodbankprojectspring.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class CommonAtributsModel implements Serializable {

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false, unique = true, length = 10)
    private UUID id;

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
