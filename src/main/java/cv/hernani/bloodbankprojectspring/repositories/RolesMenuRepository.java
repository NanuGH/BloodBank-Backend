package cv.hernani.bloodbankprojectspring.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import cv.hernani.bloodbankprojectspring.models.RolesMenuModel;
import cv.hernani.bloodbankprojectspring.models.RolesModel;

import java.util.*;

public interface RolesMenuRepository extends JpaRepository<RolesMenuModel,UUID> {

    List<RolesMenuModel> findByIdRoles(RolesModel idRoles);
    
    
}
