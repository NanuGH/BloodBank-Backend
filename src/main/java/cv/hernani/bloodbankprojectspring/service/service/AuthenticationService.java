package cv.hernani.bloodbankprojectspring.service.service;

import cv.hernani.bloodbankprojectspring.dtos.AuthenticationDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface AuthenticationService {
    
    public APIResponse getAuthentication(AuthenticationDto authenticationDto);
}
