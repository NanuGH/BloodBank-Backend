package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_roles")
public class RolesModel extends CommonAtributsModel {

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="code", nullable = false)
    private String code;

}
