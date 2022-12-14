package cv.hernani.bloodbankprojectspring.service.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.EmployeeDto;
import cv.hernani.bloodbankprojectspring.dtos.EmployeeUpdtDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface EmployeeService {
    public APIResponse createEmployee(EmployeeDto employeeDto, UUID idRoles);
    public APIResponse updtEmployee(UUID id, EmployeeUpdtDto employeeUpdtDto);
    public APIResponse findAllEmployee();
    public APIResponse findEmployeeById(UUID id);
    //public APIResponse findEmploByOptionals(String identifNumber,String email);
    public APIResponse deleteEmployee(UUID id);
    public APIResponse changeStatus(UUID id);
    public APIResponse resetPassword(String email,String password);


    public APIResponse findEmploByOptionals(String namePerson, String identifNumber, String email);
    public APIResponse findEmployeeByEmail(String email);

}
