package cv.hernani.bloodbankprojectspring.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import cv.hernani.bloodbankprojectspring.models.BloodDonorModel;
import cv.hernani.bloodbankprojectspring.models.PersonModel;

public interface BloodDonorRepository extends JpaRepository<BloodDonorModel, UUID> {
    Optional <BloodDonorModel> findByIdentifNumber(String identifNumber);

    Optional <BloodDonorModel> findByIdPerson(PersonModel idPerson);
    List<BloodDonorModel> findByIdPersonNamePersonOrIdentifNumberContainingAllIgnoreCase(String value, String identifNumber);
}
    