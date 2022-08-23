package cv.hernani.bloodbankprojectspring.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cv.hernani.bloodbankprojectspring.dtos.EmployeeDto;
import cv.hernani.bloodbankprojectspring.models.EmployeeModel;
import cv.hernani.bloodbankprojectspring.service.EmployeeService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("employee")
public class EmployeeController {
    
    final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Object> createEmployee(EmployeeDto employeeDto){
        if (employeeService.existEmployee(employeeDto.getNamePerson(), employeeDto.getSurnamePerson(), employeeDto.getIdentNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Employee already exists on DB!");
        }

        var employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeDto, employeeModel);
        employeeModel.setInsertionDate(LocalDateTime.now());
        employeeModel.setUpdateDate(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeModel));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeModel>>getAllEmployee(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable(value = "id")UUID id) {
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
        return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted!");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid EmployeeDto employeeDto){

        Optional<EmployeeModel> employeeModelOptional = employeeService.findEmployeeById(id);
        if (employeeModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not Found!");
        }

        var employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeDto, employeeModel);
        employeeModel.setId(employeeModelOptional.get().getId());
        employeeModel.setInsertionDate(employeeModelOptional.get().getInsertionDate());

        return ResponseEntity.status(HttpStatus.OK).body(employeeService.createEmployee(employeeModel));
    }

}
