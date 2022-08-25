package cv.hernani.bloodbankprojectspring.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cv.hernani.bloodbankprojectspring.dtos.EmployeeDto;
import cv.hernani.bloodbankprojectspring.models.EmployeeModel;
import cv.hernani.bloodbankprojectspring.service.EmployeeService;


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
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeDto));

    }

    /*  CASTIGO DE ADILSON CORREIA FUNCIONAL @PostMapping
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        if (employeeService.existEmployee(employeeDto.getNamePerson(), employeeDto.getSurnamePerson(), employeeDto.getIdentifNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Employee already exists on DB!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeDto));
    }*/

    @GetMapping
    public ResponseEntity<List<EmployeeModel>>getAllEmployee(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable(value = "id") UUID id) {
        Optional<EmployeeModel> employeeModelOptional = employeeService.findEmployeeById(id);
        if (!employeeModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employeeModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable(value = "id") UUID id){
        Optional<EmployeeModel> employeeModelOptional = employeeService.findEmployeeById(id);
        if(!employeeModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!");
        }

        employeeService.deleteEmployee(employeeModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted!");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid EmployeeDto employeeDto){

        Optional<EmployeeModel> employeeModelOptional = employeeService.findEmployeeById(id);
        if (!employeeModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not Found!");
        }

        var employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeDto, employeeModel);
        employeeModel.setId(employeeModelOptional.get().getId());
        employeeModel.setInsertionDate(employeeModelOptional.get().getInsertionDate());     
        employeeModel.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.OK).body(employeeService.createEmployee(employeeDto));
    }
    

}
