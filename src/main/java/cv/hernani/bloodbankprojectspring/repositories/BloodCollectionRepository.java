package cv.hernani.bloodbankprojectspring.repositories;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;

@Repository
public interface BloodCollectionRepository extends JpaRepository<BloodCollectionModel,UUID>{
    
    List<BloodCollectionModel> findByCollectionNumberAndInsertionDate(String collectionNumber, LocalDateTime insertionDate);
    List<BloodCollectionModel> findByCollectionNumber(String collectionNumber);
    List<BloodCollectionModel> findByInsertionDate(LocalDateTime insertionDate);

    Optional<BloodCollectionModel> existsByCollectionNumber(String collectionNumber);
    //Optional <BloodDonorModel> findByIdentifNumber(String identifNumber);
    //Optional <BloodCollectionModel> findByCollectionNumber(String collectionNumber);

   // @Query(value="Select * FROM tb_blood_collection where to_char(insertion_date::DATE, 'yyyy-MM-dd') LIKE %:date%",nativeQuery=true)List<BloodCollectionModel> searchInsertionDateLike(@Param("date")String date);

    @Query(value="Select * FROM tb_blood_collection where to_char(insertion_date::DATE, 'yyyy-MM-dd') LIKE %:date%",nativeQuery=true)List<BloodCollectionModel> searchInsertionDateLike(LocalDateTime date);
}

/* id,who_updated,dm_code_disabled,insertion_date,dm_status,update_date,who_inserted,external_collection,quantidade,fk_id_employee,fk_id_donor,collection_number */