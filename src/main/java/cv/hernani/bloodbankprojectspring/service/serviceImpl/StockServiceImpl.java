package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import cv.hernani.bloodbankprojectspring.dtos.StockDto;
import cv.hernani.bloodbankprojectspring.dtos.StockUpdtDto;
import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;
import cv.hernani.bloodbankprojectspring.models.StockModel;
import cv.hernani.bloodbankprojectspring.repositories.BloodCollectionRepository;
import cv.hernani.bloodbankprojectspring.repositories.StockRepository;
import cv.hernani.bloodbankprojectspring.service.service.StockService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class StockServiceImpl implements StockService {

    final StockRepository stockRepository;
    final BloodCollectionRepository bloodCollectRepository;

    public StockServiceImpl(StockRepository stockRepository, BloodCollectionRepository bloodCollectRepository) {
        this.stockRepository = stockRepository;
        this.bloodCollectRepository = bloodCollectRepository;
    }

    @Override
    public APIResponse createStock(@RequestBody @Valid StockDto stockDto, UUID id) {
        Optional<BloodCollectionModel> bloodCollectOptional = bloodCollectRepository.findById(id);
        if (!bloodCollectOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Colheita não existe!")).build();
        }

        boolean stockOptional = stockRepository.existsByIdcollection(bloodCollectOptional.get());
            if (stockOptional==true) {
                return APIResponse.builder().status(false)
                        .message(MessageState.ERRO_DE_INSERCAO)
                        .details(Arrays.asList("ERRO: Colheita já existe no Stock!")).build();
            }           
        
        var stockModel = new StockModel();
        try {
            BeanUtils.copyProperties(stockDto,stockModel);
            stockModel.setIdcollection(bloodCollectOptional.get());
            stockRepository.save(stockModel);
            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }
    }

    @Override
    public APIResponse updateStock( UUID id, @RequestBody @Valid StockUpdtDto stockUpdtDto){
        Optional<StockModel> StockModelOptional = stockRepository.findById(id);
        if (!StockModelOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: Coleta não existe no Stock!")).build();
        }
        var stockModel = new StockModel();

        try {
            BeanUtils.copyProperties(stockUpdtDto, stockModel);
            stockModel.setId(StockModelOptional.get().getId());
            stockModel.setIdcollection(StockModelOptional.get().getIdcollection());
            stockModel.setWhoInserted(StockModelOptional.get().getWhoInserted());
            stockRepository.save(stockModel);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();
        }    
    }

    @Override
    public APIResponse getAllStock() {
        List<StockModel> getAllStock = stockRepository.findAll();
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(getAllStock)).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getStockById(UUID id){
        if (!stockRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Donation dont exists on Stock!")).build();
        }
        Optional<StockModel> stockModel = stockRepository.findById(id);
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(stockModel)).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }

    }

    @Override
    public APIResponse deleteStockById(UUID id){
        if (!stockRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Donation dont exists on Stock!")).build();
        }
        try {
            stockRepository.deleteById(id);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).details(Arrays.asList(e.getMessage())).build();
        }
    }



}