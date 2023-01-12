package cv.hernani.bloodbankprojectspring.controllers;

import java.util.UUID;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cv.hernani.bloodbankprojectspring.dtos.EmployeeDto;
import cv.hernani.bloodbankprojectspring.dtos.EmployeeUpdtDto;
import cv.hernani.bloodbankprojectspring.service.service.EmployeeService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/employee")
public class EmployeeController {
    
    final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

   /*@PostMapping
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        if (employeeService.existEmployee(employeeDto.getNamePerson(), employeeDto.getSurnamePerson(), employeeDto.getIdentifNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Employee already exists on DB!");
        }

        var employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeDto, employeeModel);
        employeeModel.setInsertionDate(LocalDateTime.now(ZoneId.of("UTC")));
        employeeModel.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeModel));
    }*/
     
    @PostMapping("/{idroles}")
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeDto employeeDto,
                                                              @PathVariable(value = "idroles") UUID idroles){
        APIResponse response = employeeService.createEmployee(employeeDto,idroles);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<Object> getAllEmployee(){
        APIResponse response = employeeService.findAllEmployee() ;
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable(value = "id") UUID id) {  
        APIResponse response = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    } 

    @GetMapping("email/{email}")
    public ResponseEntity<Object> getEmployeeByEmail(@PathVariable(value = "email") String email) {  
        APIResponse response = employeeService.findEmployeeByEmail(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    } 

    @GetMapping("/getEmplOpts")
    public ResponseEntity<Object> getPersonOptional(@RequestParam(required=false)String identifNumber,
                                                    @RequestParam(required=false) String email) {
        APIResponse response = employeeService.findEmploByOptionals(email, identifNumber, email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") UUID id){
        APIResponse response = employeeService.deleteEmployee(id);
        return new ResponseEntity<>(response,HttpStatus.OK);        
    }
    

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") UUID id,
                                                 @RequestBody @Valid EmployeeUpdtDto employeeUpdtDto){
        APIResponse response = employeeService.updtEmployee(id, employeeUpdtDto);
        return new ResponseEntity<>(response,HttpStatus.OK);                                         
    }
    
    @PutMapping(value="/changestatus/{id}")
    public ResponseEntity<Object> changeStatus(@PathVariable("id") UUID id){
        APIResponse response = employeeService.changeStatus(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }   


    @PutMapping("reset/{email}/{password}")
    public ResponseEntity<Object> resetPassword(@PathVariable(value = "email") String email,
                                               @PathVariable(value = "password") String password){
        APIResponse response = employeeService.resetPassword(email, password);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchAutuante(
            @RequestParam(required = false) String namePerson,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String identifNumber) {

        APIResponse response = employeeService.findEmploByOptionals(namePerson, identifNumber, email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
       
    

}
  