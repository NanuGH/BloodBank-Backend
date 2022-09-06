package cv.hernani.bloodbankprojectspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cv.hernani.bloodbankprojectspring.models.RolesModel;

public interface RolesRepository extends JpaRepository<RolesModel,UUID> {
    boolean existsByName(String name);
}
