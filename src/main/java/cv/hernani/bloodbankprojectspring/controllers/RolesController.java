package cv.hernani.bloodbankprojectspring.controllers;

import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cv.hernani.bloodbankprojectspring.dtos.RolesDto;
import cv.hernani.bloodbankprojectspring.service.service.RolesService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/roles")
public class RolesController {
    
    @Autowired
    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createRoles(@Valid @RequestBody RolesDto rolesDto) {
        APIResponse response = rolesService.createRoles(rolesDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Object> getAllRoles() {
        APIResponse response = rolesService.getAllRoles();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<Object> getRolesById(@PathVariable("id") UUID id){
        APIResponse response = rolesService.getRolesById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteRoles(@PathVariable("id") UUID id){
       APIResponse response = rolesService.deleteRoles(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Object> updateRoles(@PathVariable("id") UUID id,@RequestBody @Valid RolesDto rolesDto){
        APIResponse response = rolesService.updateRoles(id, rolesDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping(value ="/roles/{dmFunction}")
    public ResponseEntity<Object> getBloodCollectByNumber(@PathVariable("dmFunction") String dmFunction) {
        APIResponse response = rolesService.getRoleByName(dmFunction);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
