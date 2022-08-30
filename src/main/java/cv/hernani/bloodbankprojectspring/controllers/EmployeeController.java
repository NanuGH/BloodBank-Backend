package cv.hernani.bloodbankprojectspring.controllers;

import java.util.UUID;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cv.hernani.bloodbankprojectspring.dtos.EmployeeDto;
import cv.hernani.bloodbankprojectspring.dtos.EmployeeUpdtDto;
import cv.hernani.bloodbankprojectspring.service.EmployeeService;
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

    @PostMapping
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        APIResponse response = employeeService.createEmployee(employeeDto);
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
    

}
