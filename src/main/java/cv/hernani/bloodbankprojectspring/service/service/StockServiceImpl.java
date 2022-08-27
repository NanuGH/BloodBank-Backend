package cv.hernani.bloodbankprojectspring.service.service;

import cv.hernani.bloodbankprojectspring.dtos.StockDto;

@Service
public class StockServiceImpl implements StockService {

    final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public APIResponse createStock(StockDto stockDto) {
        try {
            var stockModel= new StockModel();
            BeanUtils.copyProperties(bloodCollectionDto,bloodCollectModel);
            bloodCollectRepository.save(bloodCollectModel);
            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }
    }

    @Override
    APIResponse updateStock(UUID id,StockDto stockDto){
        Optional<StockModel> StockModelOptional = stockRepository.finndById(id);
        if (!StockModelOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("Conflict: Blood Collection don't exists on DB!")).build();
        }
        var stockModel = new StockModel();

        try {
            BeanUtils.copyProperties(stockDto, stockModel);
            stockModel.setId(StockModelOptional.get().getId());
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
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Collection dont exists on Stock!")).build();
        }
        Optional<StockModel> stockModel = stockRepository.findById(id);
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(stockModel)).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }

    }

    public APIResponse deleteStockById(UUID id){
        if (!stockRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Collection dont exists on Stock!")).build();
        }
        try {
            stockRepository.deleteById(id);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).details(Arrays.asList(e.getMessage())).build();
        }
    }


}