package cv.hernani.bloodbankprojectspring.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    private List<RolesModel> roles;

    /*@JoinTable(name = "tb_roles_menu",
	 joinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "id"),
	 inverseJoinColumns = @JoinColumn(name = "id_roles", referencedColumnName = "id"))
    private Set<MenuModel> parties = new HashSet<MenuModel>();*/


}