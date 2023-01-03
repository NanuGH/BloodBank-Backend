package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.TransfusionDto;
import cv.hernani.bloodbankprojectspring.models.TransfusionModel;
import cv.hernani.bloodbankprojectspring.repositories.BloodCollectionRepository;
import cv.hernani.bloodbankprojectspring.repositories.EmployeeRepository;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;
import cv.hernani.bloodbankprojectspring.repositories.TransfusionRepository;
import cv.hernani.bloodbankprojectspring.service.service.TransfusionService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class TransfusionServiceImpl implements TransfusionService{

    final TransfusionRepository transfusionRepository;
    final EmployeeRepository employeeRepository;
    final PersonRepository personRepository;
    final BloodCollectionRepository bloodCollectionRepository;    

    public TransfusionServiceImpl(TransfusionRepository transfusionRepository, EmployeeRepository employeeRepository,
                                  PersonRepository personRepository, BloodCollectionRepository bloodCollectionRepository) {
        this.transfusionRepository = transfusionRepository;
        this.employeeRepository = employeeRepository;
        this.personRepository = personRepository;
        this.bloodCollectionRepository = bloodCollectionRepository;
    }
/* 
    @Override
    public APIResponse createTransfusion(TransfusionDto transfusionDto,UUID idEmployee,UUID idPerson,UUID idCollection ) {
        
        if (!personRepository.existsById(idPerson)) { 
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Esta pessoa não existe na BD!")).build();
        }
        
        if (!employeeRepository.existsById(idEmployee)) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: Este empregado não existe na BD!")).build();
        }
        
        /* if (!bloodCollectionRepository.existsById(idCollection)) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Esta Colheita não existe na BD!")).build();  
        } */
        
       /* var transfusionModel = new TransfusionModel(); 
        Optional<PersonModel> personModelOptional = personRepository.findById(idPerson);
        Optional<EmployeeModel> employeeOptional = employeeRepository.findById(idEmployee);
        Optional<BloodCollectionModel> bloodCollectOptional = bloodCollectionRepository.findById(idCollection);
        try {
            BeanUtils.copyProperties(transfusionDto,transfusionModel);
            transfusionModel.setId(bloodCollectOptional.get());
            //transfusionModel.setIdPerson(personModelOptional.get());
            transfusionModel.setId(employeeOptional.get());
            transfusionRepository.save(transfusionModel);
            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }

    }*/

    @Override
    public APIResponse getAllTransfusion() {
        List<TransfusionModel> getAllTransfusion = transfusionRepository.findAll();
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(getAllTransfusion)).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getTransfusionById(UUID id) {
        if (!transfusionRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("ERRO: Esta transfusão não existe!")).build();
        }
        Optional<TransfusionModel> transfusionModel = transfusionRepository.findById(id);
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(transfusionModel)).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse deleteTransfusion(UUID id) {
        if (!transfusionRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Donation dont exists on Stock!")).build();
        }
        try {
            transfusionRepository.deleteById(id);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse updateTransfusion(UUID id, TransfusionDto transfusionDto) {
        Optional<TransfusionModel> transfusionalOptional = transfusionRepository.findById(id);
        if (!transfusionalOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: Esta transfusão não existe!")).build();
        }
        var transfusionModel = transfusionalOptional.get();

        try {
            BeanUtils.copyProperties(transfusionalOptional, transfusionModel);
            transfusionRepository.save(transfusionModel);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();
            
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();
        }  
    }
    
}
