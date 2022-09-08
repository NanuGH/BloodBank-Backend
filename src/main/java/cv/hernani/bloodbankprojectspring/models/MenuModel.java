package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_menu")
public class MenuModel extends CommonAtributsModel{

    @Column(name="name", nullable = true)
    private String name;

    @Column(name="code", nullable = true)
    private String code;

}