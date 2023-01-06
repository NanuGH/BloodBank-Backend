package cv.hernani.bloodbankprojectspring.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import cv.hernani.bloodbankprojectspring.models.RolesModel;

public interface RolesRepository extends JpaRepository<RolesModel,UUID> {
    boolean existsByName(String name);
    Optional <RolesModel> findByName(String name);
    List<RolesModel> findAll();
}
