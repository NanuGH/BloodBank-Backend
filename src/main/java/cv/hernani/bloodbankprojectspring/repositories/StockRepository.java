package cv.hernani.bloodbankprojectspring.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;
import cv.hernani.bloodbankprojectspring.models.StockModel;

public interface StockRepository extends JpaRepository<StockModel,UUID>{
    boolean existsByCollection(BloodCollectionModel collection);
    boolean existsByCollection(String collection);
    boolean existsByCollection_CollectionNumber(String collectioNumber);

    Optional <StockModel> findByCollection_CollectionNumber(String collectioNumber);
    Optional<StockModel> existsByDmCodeStockType(String dmCodeStockType);
    Optional <StockModel> findByCollection(String collection);

    List<StockModel> findByDmCodeStockType(String dmCodeStockType );
}

  