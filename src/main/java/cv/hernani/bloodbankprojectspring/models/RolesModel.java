package cv.hernani.bloodbankprojectspring.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_roles")
public class RolesModel extends CommonAtributsModel {

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="code", nullable = false)
    private String code;

    /*@ManyToMany(mappedBy = "menu")
    private List<MenuModel> menu; 
    /*@ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "tb_roles_menu",
	 joinColumns = @JoinColumn(name = "id_roles", referencedColumnName = "id"),
	 inverseJoinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "id"))
    private Set<RolesModel> parties = new HashSet<RolesModel>();*/

}
