package cv.hernani.bloodbankprojectspring.service.ServiceImplement;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import cv.hernani.bloodbankprojectspring.dtos.EmployeeDto;
import cv.hernani.bloodbankprojectspring.models.EmployeeModel;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.repositories.EmployeeRepository;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;
import cv.hernani.bloodbankprojectspring.service.EmployeeService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.Helper;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;


@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    final EmployeeRepository employeeRepository;
    private PersonModel personModel;
    private EmployeeModel employeeModel;
    private final PersonRepository personRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PersonRepository personRepository){
        this.employeeRepository = employeeRepository;
        this.personRepository = personRepository;
    }

    /*@Transactional
    public APIResponse createEmployee(EmployeeDto employeeDto){     
        try {
            var pModel = new PersonModel();
            BeanUtils.copyProperties(employeeDto.getPersonDto(), pModel);
            personRepository.save(pModel);

            try {//caso erro salvar na tab Employee
             employeeModel.setWhoInserted(employeeDto.getPersonDto().getWhoInserted());
             String identfNumber = Helper.identfNumberGenerator();
             employeeModel.setIdentifNumber(identfNumber);
             employeeModel.setPw(Helper.passEncoder().encode(employeeDto.getPw())); 
             employeeModel.setDmfunction(employeeDto.getDmfunction());  
             employeeModel.setIdPerson(pModel);                
             
             employeeRepository.save(employeeModel);

             return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
            } catch (Exception e) {
                return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
            }
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR).build();
        }     
    }*/

    public APIResponse createEmployee(EmployeeDto employeeDto){     
        try {
            var pModel = new PersonModel();
            BeanUtils.copyProperties(employeeDto.getPersonDto(), pModel);
            personRepository.save(pModel);
            try {//caso erro salvar na tab Employee
             var employeeModel = new EmployeeModel();
             employeeModel.setWhoInserted(employeeDto.getPersonDto().getWhoInserted());
             employeeModel.setWhoUpdated(employeeDto.getPersonDto().getWhoUpdated());
             String identfNumber = Helper.identfNumberGenerator();
             employeeModel.setIdentifNumber(identfNumber);
             employeeModel.setPw(employeeDto.getPw()); 
             employeeModel.setDmfunction(employeeDto.getDmfunction());  
             employeeModel.setIdPerson(pModel);
             employeeModel.setInsertionDate(pModel.getInsertionDate());
             employeeModel.setUpdateDate(pModel.getUpdateDate());

             employeeRepository.save(employeeModel);

             return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
            } catch (Exception e) {
                return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
            }
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR).build();
        }     
    }


    /*public boolean existEmployee(String namePerson, String surnamePerson, String identifNumber){
        return employeeRepository.existsByNamePersonAndSurnamePersonAndIdentifNumber(namePerson, surnamePerson, identifNumber);
    }*/

    public List<EmployeeModel> findAll(){
        return employeeRepository.findAll();
    }

    public Optional<EmployeeModel> findEmployeeById(UUID id){
        return employeeRepository.findById(id);
    }

    @Transactional
    public void deleteEmployee(EmployeeModel employeeModel){
        employeeRepository.delete(employeeModel);
    }

   
}
