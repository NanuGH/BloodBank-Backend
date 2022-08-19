package cv.hernani.bloodbankprojectspring.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "tb_blood_receiver")
public class BloodReceiverModel extends CommonPersonAtributsModel{

    @Column(name = "fk_dm_typePerson")
    private String dmTypePerson;

    

    
    
}
