package cv.hernani.bloodbankprojectspring.controllers;

import org.springframework.web.bind.annotation.*;
import cv.hernani.bloodbankprojectspring.service.service.AuthenticationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    
   /*  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postAuthentication(@Valid @RequestBody AuthenticationDto authenticationDto) {
                                                        
        APIResponse response = authenticationService.postAuthentication(authenticationDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    } */
}
