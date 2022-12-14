package cv.hernani.bloodbankprojectspring.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_stock")
public class StockModel extends CommonAtributsModel {

    @ManyToOne
    @JoinColumn(name="fk_id_collection", nullable = false)
    private BloodCollectionModel collection;

    @Column(name="expiration_date", nullable = false)
    private Date expirationDate;

    @Column(name="dm_stock_type", nullable = false)
    private String dmCodeStockType;   
        
}
