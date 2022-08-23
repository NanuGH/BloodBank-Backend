package cv.hernani.bloodbankprojectspring.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import cv.hernani.bloodbankprojectspring.dtos.EmployeeDto;
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

    /*@Transactional
    public EmployeeModel createEmployee(EmployeeDto employeeDto){ 
        EmployeeModel employeeModel = new EmployeeModel();
        try {
            employeeModel.setBirthday(employeeDto.getBirthday());
            employeeModel.setDmDocIdent(employeeDto.getDmDocIdent());
            employeeModel.setDmHomeAdd(employeeDto.getDmHomeAdd());
            employeeModel.setDmSex(employeeDto.getDmSex());
            employeeModel.setGrade(employeeDto.getGrade());
            employeeModel.setJobAddress(employeeDto.getJobAddress());
            employeeModel.setNamePerson(employeeDto.getNamePerson());
            employeeModel.setSurnamePerson(employeeDto.getSurnamePerson());
            employeeModel.setPicturePerson(employeeDto.getPicturePerson());
            employeeModel.setProfession(employeeDto.getProfession());
            employeeModel.setWhoInserted(employeeDto.getWhoInserted());
            employeeModel.setWhoUpdated(employeeDto.getWhoUpdated());
            employeeModel.setPw(employeeDto.getPw());
            employeeModel.setDmfunction(employeeDto.getDmfunction());
            employeeModel.setIdentifNumber(employeeDto.getIdentifNumber());
            employeeModel.setDmBloodCode(employeeDto.getDmBloodCode());

            employeeModel.setInsertionDate(LocalDateTime.now(ZoneId.of("UTC")));
            employeeModel.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));

            //BeanUtils.copyProperties(employeeDto, employeeModel);

            return employeeRepository.save(employeeModel);
        } catch (Exception e) {
            List<Object> l = new ArrayList<>();
            l.add(e.getMessage());
        }
        return employeeModel;
    }*/

    public boolean existEmployee(String namePerson, String surnamePerson, String identifNumber){
        return employeeRepository.existsByNamePersonAndSurnamePersonAndIdentifNumber(namePerson, surnamePerson, identifNumber);
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
