package cv.hernani.bloodbankprojectspring.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import cv.hernani.bloodbankprojectspring.models.EmployeeModel;
import cv.hernani.bloodbankprojectspring.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    
    final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public EmployeeModel createEmployee(EmployeeModel employeeModel){
        return employeeRepository.save(employeeModel);
    }

    public boolean existEmployee(String namePerson, String surnamePerson, String identNumber){
        return employeeRepository.existsByNameEmployeeAndSurnameEmployeeAndIdentNumber(namePerson,surnamePerson,identNumber);
    }

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
