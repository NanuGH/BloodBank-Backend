package cv.hernani.bloodbankprojectspring.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.EmployeeDto;
import cv.hernani.bloodbankprojectspring.models.EmployeeModel;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface EmployeeService {
    APIResponse createEmployee(EmployeeDto employeeDto);
    /*boolean existEmployee(String namePerson, String surnamePerson, String identifNumber);*/
    List<EmployeeModel> findAll();
    Optional<EmployeeModel> findEmployeeById(UUID id);
    void deleteEmployee(EmployeeModel employeeModel);
}
