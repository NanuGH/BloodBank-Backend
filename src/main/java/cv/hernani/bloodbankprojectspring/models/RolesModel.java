package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_roles")
public class RolesModel extends CommonAtributsModel {

    @Column(name="name", nullable = true, length=15 )
    private String name;
    @Column(name="code", nullable = true, length=15 )
    private String code;
    @Column(name="menu", nullable = true, length=15 )
    private String[] menu;
}
