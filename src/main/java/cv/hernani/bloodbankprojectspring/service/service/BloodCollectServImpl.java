package cv.hernani.bloodbankprojectspring.service.service;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.BloodCollectionDto;
import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;
import cv.hernani.bloodbankprojectspring.models.EmployeeModel;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.repositories.BloodCollectionRepository;
import cv.hernani.bloodbankprojectspring.repositories.EmployeeRepository;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;
import cv.hernani.bloodbankprojectspring.service.BloodCollectionService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class BloodCollectServImpl implements BloodCollectionService {

    final BloodCollectionRepository bloodCollectRepository;
    final PersonRepository personRepository;
    final EmployeeRepository employeeRepository;  

    public BloodCollectServImpl(BloodCollectionRepository bloodColectRepo, PersonRepository personRepository, EmployeeRepository employeeRepository) {
        this.bloodCollectRepository = bloodColectRepo;
        this.personRepository = personRepository;
        this.employeeRepository = employeeRepository;
    }
      

    @Override
    public APIResponse createBloodColection(BloodCollectionDto bloodCollectionDto) {
        try {
            /*var personModel = new PersonModel();
            var employeeModel = new EmployeeModel();*/
            var bloodCollectModel= new BloodCollectionModel();
            BeanUtils.copyProperties(bloodCollectionDto,bloodCollectModel);
            bloodCollectRepository.save(bloodCollectModel);
            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }
    }

    
}
