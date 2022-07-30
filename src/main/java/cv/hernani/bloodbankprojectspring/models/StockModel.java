package cv.hernani.bloodbankprojectspring.models;

import java.util.Date;
import java.util.UUID;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_stock")
public class StockModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_stock",nullable = false, unique = true, length = 10)
    private UUID idstock;

    @Column(name="id_colheita", nullable = false)
    private String idColheita;

    @Column(name="expiration_date", nullable = false)
    private Date expirationDate;

    @Column(name="dm_stock_type", nullable = false)
    private Date dmStockType;

        
}
