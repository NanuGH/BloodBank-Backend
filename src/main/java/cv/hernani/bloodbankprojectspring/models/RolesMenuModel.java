package cv.hernani.bloodbankprojectspring.models;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_roles_menu")
public class RolesMenuModel extends CommonAtributsModel {
    
    @ManyToOne
    @JoinColumn(name = "fk_id_roles", nullable = false)
    private RolesModel idRoles;

    @ManyToOne
    @JoinColumn(name = "fk_id_menu", nullable = false)
    private MenuModel idMenu;
}
