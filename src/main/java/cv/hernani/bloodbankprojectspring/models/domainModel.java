package cv.hernani.bloodbankprojectspring.models;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_domain")
public class DomainModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_domain",nullable = false, unique = true, length = 38)
    private UUID idDomain;

    @Column(name="domain", nullable = false, length = 15)
    private String domain;

    @Column(name="domain_name", nullable = false, length = 15)
    private String dmName;

    @Column(name="domain_code", nullable = false, length = 15)
    private String dmCode;

    @Column(name="domain_order", nullable = false, length = 2)
    private String dmOrder;

    @Column(name="self_id", nullable = false, length = 38)
    private String selfId;

   

}
