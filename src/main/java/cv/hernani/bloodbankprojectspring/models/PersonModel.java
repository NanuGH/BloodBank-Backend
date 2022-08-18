package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_person")
public class PersonModel extends CommonPersonAtributsModel{

    @Column(name="dm_type_person", nullable = false, length = 10)
    private String dmTypePerson;
    
}