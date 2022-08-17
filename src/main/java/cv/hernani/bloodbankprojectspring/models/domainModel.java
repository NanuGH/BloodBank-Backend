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
@Table(name = "tb_domain")
public class DomainModel implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_domain",nullable = false, unique = true, length = 10)
    private UUID idDomain;

    @Column(name="domain_name", nullable = false)
    private String domainName;

    @Column(name="domain_code", nullable = false)
    private String domainCode;

    @Column(name="domain_order", nullable = false)
    private String domainOrder;

    @Column(name="self_id", nullable = false)
    private String selfId;

}
