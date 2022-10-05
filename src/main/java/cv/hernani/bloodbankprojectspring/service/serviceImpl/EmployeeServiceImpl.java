package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import javax.validation.Valid;
import cv.hernani.bloodbankprojectspring.dtos.EmployeeDto;
import cv.hernani.bloodbankprojectspring.dtos.EmployeeUpdtDto;
import cv.hernani.bloodbankprojectspring.models.EmployeeModel;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.repositories.EmployeeRepository;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;
import cv.hernani.bloodbankprojectspring.service.service.EmployeeService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.Helper;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;



@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    final EmployeeRepository employeeRepository;
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

    @Override
    public APIResponse createEmployee(EmployeeDto employeeDto){
        if(personRepository.existsByNamePersonAndSurnamePersonAndDmDocIdent(employeeDto.getPersonDto().getDmDocIdent(),
                                                                            employeeDto.getPersonDto().getNamePerson(),
                                                                            employeeDto.getPersonDto().getSurnamePerson())){

            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Pessoa ja existe na BD!")).build();
        }
              
        try {
            var personModel = new PersonModel();
            BeanUtils.copyProperties(employeeDto.getPersonDto(), personModel);
            personRepository.save(personModel);
            try {//caso erro salvar na tab Employee
             var employeeModel = new EmployeeModel();
             employeeModel.setWhoInserted(employeeDto.getPersonDto().getWhoInserted());
             employeeModel.setWhoUpdated(employeeDto.getPersonDto().getWhoUpdated());
             String identfNumber = Helper.identfNumberGenerator();
             employeeModel.setIdentifNumber(identfNumber);
             employeeModel.setPw(employeeDto.getPw()); 
             employeeModel.setDmFunction(employeeDto.getDmFunction());  
             employeeModel.setIdPerson(personModel);
             employeeModel.setInsertionDate(personModel.getInsertionDate());
             employeeModel.setUpdateDate(personModel.getUpdateDate());
             //employeeModel.setIdRole(employeeDto.getIdRoles());
             employeeModel.setEmail(employeeDto.getEmail());

             employeeRepository.save(employeeModel);

             return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
            } catch (Exception e) {
                return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
            }
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR).build();
        }     
    }

   /*@Override
    public APIResponse updtEmployee(UUID id, EmployeeUpdtDto employeeUpdtDto) {
        Optional<EmployeeModel> employeeModelOptional = employeeRepository.findById(id);
        if (!employeeModelOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("Conflict: Domain don't exists on DB!"))
                    .build();
        }
        var employeeModel = employeeModelOptional.get(); 
        try {
            //BeanUtils.copyProperties(employeeModelOptional, employeeModel);
            //employeeModel.setId(employeeModelOptional.get().getId());
            employeeModel.setPw(employeeUpdtDto.getPw());
            employeeModel.setDmfunction(employeeUpdtDto.getDmfunction());
            employeeModel.setWhoUpdated(employeeUpdtDto.getWhoUpdated());

            employeeRepository.save(employeeModel);
            return APIResponse.builder().status(true)
                    .message(MessageState.ATUALIZADO_COM_SUCESSO).build();

        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO_AO_ATUALIZAR)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }*/
    
    @Override
    public APIResponse updtEmployee(UUID id, @RequestBody @Valid EmployeeUpdtDto employeeUpdtDto) {
        Optional<EmployeeModel> employeeModelOptional = employeeRepository.findById(id);
        EmployeeModel employeeModel = employeeModelOptional.get(); 
        if (!employeeModelOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("Conflict: Employee don't exists on DB!"))
                    .build();
        }
       Optional<PersonModel> personOptional = personRepository.findById(employeeModel.getIdPerson().getId());
        PersonModel personModel = personOptional.get(); 
        if (!personOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("Conflict: Person don't exists on DB!"))
                    .build();
        }
        try {            
            //BeanUtils.copyProperties(employeeUpdtDto, employeeModel);  
            employeeModel.setPw(Helper.passEncoder().encode(employeeUpdtDto.getPw())); 
            employeeModel.setDmFunction(employeeUpdtDto.getDmfunction());
            employeeModel.setWhoUpdated(employeeUpdtDto.getWhoUpdated());
            employeeRepository.save(employeeModel);
            
            personModel.setWhoUpdated(employeeUpdtDto.getWhoUpdated());         
            personRepository.save(personModel);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }   

    @Override
    public APIResponse findAllEmployee() {
      List<EmployeeModel> findAllEmployee = employeeRepository.findAll();
      try {
        return APIResponse.builder().status(true).message(MessageState.SUCESSO)
                                    .details(Arrays.asList(findAllEmployee)).build(); 
      } catch (Exception e) {
        return APIResponse.builder().status(false).message(MessageState.ERRO)
                                    .details(Arrays.asList(e.getMessage())).build();
      }
        
    }

    @Override
    public APIResponse findEmployeeById(UUID id){
        if (!employeeRepository.existsById(id)) {
            return APIResponse.builder().status(false)
                    .details(Arrays.asList("Conflict: Employee dont exists on DB!"))
                    .build();
        }
        Optional<EmployeeModel> employeeModel = employeeRepository.findById(id);
        try {

            return APIResponse.builder().status(true)
                    .message(MessageState.SUCESSO)
                    .details(Arrays.asList(employeeModel)).build();

        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Transactional
    @Override
    public APIResponse deleteEmployee(UUID id){
        if (!employeeRepository.existsById(id)) {
            return APIResponse.builder().status(false)
                    .details(Arrays.asList("Conflict: Employee dont exists on DB!"))
                    .build();
        }
        try {
            employeeRepository.deleteById(id);
            return APIResponse.builder().status(true)
                    .message(MessageState.REMOVIDO_COM_SUCESSO).build();

        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO).build();
        }
    }

    @Override
    public APIResponse findEmploByOptionals(String identifNumber, String email) {

        try {
            List<EmployeeModel> getEmployee = new ArrayList<>();  

            if (identifNumber != "" && email != "") {
                getEmployee = employeeRepository.findByIdentifNumberAndEmail(identifNumber, email);

            }
            if (identifNumber==null && email=="") {
                getEmployee = employeeRepository.findByEmail(email);

            }
            if (identifNumber!="" && email==null) {
                getEmployee = employeeRepository.findByIdentifNumber(identifNumber);
            }
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(getEmployee))
                    .build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage()))
                    .build();
        }
    }
 

   
}
