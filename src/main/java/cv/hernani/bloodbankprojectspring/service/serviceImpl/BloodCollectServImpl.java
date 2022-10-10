package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import cv.hernani.bloodbankprojectspring.dtos.BloodCollectionDto;
import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;
import cv.hernani.bloodbankprojectspring.models.EmployeeModel;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.repositories.BloodCollectionRepository;
import cv.hernani.bloodbankprojectspring.repositories.EmployeeRepository;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;
import cv.hernani.bloodbankprojectspring.service.service.BloodCollectionService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BloodCollectServImpl implements BloodCollectionService {

    final BloodCollectionRepository bloodCollectRepository;
    final PersonRepository personRepository;
    final EmployeeRepository employeeRepository;  

    public BloodCollectServImpl(BloodCollectionRepository bloodCollectRepository, PersonRepository personRepository, 
                                                                            EmployeeRepository employeeRepository) {
        this.bloodCollectRepository = bloodCollectRepository;
        this.personRepository = personRepository;
        this.employeeRepository = employeeRepository;
    }
      

    @Override
    public APIResponse createBloodCollection(@RequestBody @Valid BloodCollectionDto bloodCollectionDto, UUID idEmployee, UUID idPerson) {
        Optional<PersonModel> personModelOptional = personRepository.findById(idPerson);
        if (!personModelOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Essa pessoa não existe na BD!")).build();
        }
        
        Optional<EmployeeModel> employeeModelOptional = employeeRepository.findById(idEmployee);
        if (!employeeModelOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Este funcionário não existe na BD")) .build();
        }

        var bloodCollectModel = new BloodCollectionModel();
        var personStatus = personModelOptional.get().getStatus();

        if (personStatus.equals("false")) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Esta pessoa não esta apta para doar!")).build();
                        
        } else {
             try {
                BeanUtils.copyProperties(bloodCollectionDto,bloodCollectModel);
                bloodCollectModel.setIdPerson(personModelOptional.get());
                bloodCollectModel.setIdEmployee(employeeModelOptional.get());
                bloodCollectRepository.save(bloodCollectModel);            
                return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
            } catch (Exception e) {
                return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
            }
        }
        
    }

    @Override
    public APIResponse updtBloodCollection(UUID id, @RequestBody @Valid BloodCollectionDto bloodCollectionDto){
        Optional<BloodCollectionModel> bloodCollectOptional = bloodCollectRepository.findById(id);
        if (!bloodCollectOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: Colheita nao existe na BD!")).build();
        }
        var bloodCollectionModel = new BloodCollectionModel();

        try {
            BeanUtils.copyProperties(bloodCollectionDto, bloodCollectionModel);
            bloodCollectionModel.setId(bloodCollectOptional.get().getId());
            bloodCollectionModel.setIdPerson(bloodCollectOptional.get().getIdPerson());
            bloodCollectionModel.setIdEmployee(bloodCollectOptional.get().getIdEmployee());
            bloodCollectionModel.setWhoUpdated(bloodCollectOptional.get().getWhoUpdated());
            bloodCollectRepository.save(bloodCollectionModel);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();
        }    
    }

    @Override
    public APIResponse getAllBloodCollection() {
        List<BloodCollectionModel> getAllBloodCollect = bloodCollectRepository.findAll();
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(getAllBloodCollect)).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getBloodCollectById(UUID id){
        if (!bloodCollectRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("ERRO: Esta pessoa não existe na BD!")).build();
        }
        Optional<BloodCollectionModel> bloodCollectionModel = bloodCollectRepository.findById(id);
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(bloodCollectionModel)).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse delBloodCollection(UUID id){
        if (!bloodCollectRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("Conflict: Domain dont exists on DB!")).build();
        }
        try {
            bloodCollectRepository.deleteById(id);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).details(Arrays.asList(e.getMessage())).build();
        }
    }


    @Override
    public APIResponse findBloodCollectByOptionals( String collectionNumber, LocalDateTime insertionDate) {
        try {
            List<BloodCollectionModel> getBloodCollect = new ArrayList<>(); 
            getBloodCollect = bloodCollectRepository.findByInsertionDate(insertionDate); 

            if (collectionNumber != "" && insertionDate != null) {
                getBloodCollect = bloodCollectRepository.findByCollectionNumberAndInsertionDate(collectionNumber, insertionDate);
            }
            if (collectionNumber==null && insertionDate== null) {
                getBloodCollect = bloodCollectRepository.findByInsertionDate(insertionDate);
            }
            if (collectionNumber!="" && insertionDate==null) {
                getBloodCollect = bloodCollectRepository.findByCollectionNumber(collectionNumber);
            }
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(getBloodCollect))
                    .build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage()))
                    .build();
        }
    }

}
