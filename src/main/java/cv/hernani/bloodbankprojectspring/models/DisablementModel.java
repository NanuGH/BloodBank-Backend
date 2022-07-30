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
@Table(name = "tb_disablement")
public class DisablementModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_disablement",nullable = false, unique = true,length = 10)
    private UUID idDisablement;

    @Column(name="id_stock",nullable = false, unique = true, length = 10)
    private UUID idStock;

    @Column(name="id_employee",nullable = false, unique = true, length = 10)
    private UUID idEmployee;

    @Column(name="dm_disablement_type",nullable = false, unique = true, length = 10)
    private UUID dmDisabType;   


}
