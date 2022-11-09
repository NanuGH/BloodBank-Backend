package cv.hernani.bloodbankprojectspring.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;

@Data
@MappedSuperclass
public class CommonAtributsModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false, unique = true, length = 10)
    private UUID id;

    @Column(name="insertion_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime insertionDate;

    @UpdateTimestamp
    @Column(name="update_date", nullable = false, updatable = true)
    private LocalDateTime updateDate;

    @Column(name="who_inserted", nullable = false, updatable = false)
    private String whoInserted; 

    @Column(name="who_updated", nullable = true, updatable = true)
    private String WhoUpdated;

    @Column(name="dm_status", nullable = true)
    private String status= "true";

    @Column(name="dm_code_disabled", nullable = true)
    private String dmCodeDisabled;
    
}
