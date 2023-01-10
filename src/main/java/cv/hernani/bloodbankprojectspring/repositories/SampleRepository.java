package cv.hernani.bloodbankprojectspring.repositories;


import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import cv.hernani.bloodbankprojectspring.models.SampleModel;

public interface SampleRepository extends JpaRepository<SampleModel,UUID>{
    boolean existsBySampleNumber(String sampleNumber);
    Optional <SampleModel> findBySampleNumber(String sampleNumber);
    /*boolean existsByCollection(String collection);

    boolean existsByCollection_CollectionNumber(String collectioNumber);

    Optional <StockModel> findByCollection_CollectionNumber(String collectioNumber);

    Optional<StockModel> existsByDmCodeStockType(String dmCodeStockType);
    List<StockModel> findByDmCodeStockType(String dmCodeStockType ); */
}

  