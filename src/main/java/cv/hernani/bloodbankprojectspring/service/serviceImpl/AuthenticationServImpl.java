package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.AuthenticationDto;
import cv.hernani.bloodbankprojectspring.models.EmployeeModel;
import cv.hernani.bloodbankprojectspring.repositories.EmployeeRepository;
import cv.hernani.bloodbankprojectspring.service.service.AuthenticationService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class AuthenticationServImpl implements AuthenticationService {

    final EmployeeRepository employeeRepository;

    public AuthenticationServImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public APIResponse getAuthentication(AuthenticationDto authenticationDto) {
        if (!employeeRepository.existsByEmailAndPw(authenticationDto.getEmail(), authenticationDto.getPw())){
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: email ou pw incorreto!")).build();
        }

        Optional<EmployeeModel> employeeModel = employeeRepository.findByEmailAndPw(authenticationDto.getEmail(), authenticationDto.getPw());
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(employeeModel)).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }
    
}
