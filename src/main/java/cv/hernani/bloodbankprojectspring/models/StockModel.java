package cv.hernani.bloodbankprojectspring.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_stock")
public class StockModel extends CommonAtributsModel {

    /*@Column(name="id_colheita", nullable = false)
    private String idColheita;*/

    @ManyToOne
    @JoinColumn(name="fk_id_collection", nullable = false, unique = false)
    private BloodCollectionModel idcollection;

    @Column(name="expiration_date", nullable = false)
    private Date expirationDate;

    @Column(name="dm_stock_type", nullable = false)
    private String dmCodeStockType;
        
}
