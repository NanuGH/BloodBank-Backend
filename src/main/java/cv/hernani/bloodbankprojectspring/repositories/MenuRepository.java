package cv.hernani.bloodbankprojectspring.repositories;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import cv.hernani.bloodbankprojectspring.models.MenuModel;

public interface MenuRepository extends JpaRepository<MenuModel,UUID> {
    boolean existsByName(String name);
}
