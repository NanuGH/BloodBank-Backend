package cv.hernani.bloodbankprojectspring.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cv.hernani.bloodbankprojectspring.dtos.RolesMenuDto;
import cv.hernani.bloodbankprojectspring.service.service.RoleMenuService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/rolesmenu")
public class RolesMenuController {

    private final RoleMenuService rolesMenuService;

    public RolesMenuController(RoleMenuService rolesMenuService) {
        this.rolesMenuService = rolesMenuService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/{idRoles}/{idMenu}")
    public ResponseEntity<Object> createBloodCollect(@Valid @RequestBody RolesMenuDto rolesMenuDto, 
                                                     @PathVariable("idRoles") UUID idRoles, 
                                                     @PathVariable("idMenu") UUID idMenu) {

        APIResponse response = rolesMenuService.createRolesMenu(rolesMenuDto, idRoles, idMenu);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object>getAllTransfusion(){
        APIResponse response = rolesMenuService.getAllRolesMenu();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Object> getTransfusionById(@PathVariable("id") UUID id) {
        APIResponse response = rolesMenuService.getRolesMenuById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Object> deleteBloodCollect(@PathVariable("id") UUID id){
        APIResponse response = rolesMenuService.delRolesMenu(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBloodColeect(@PathVariable(value = "id") UUID id,
                                                     @RequestBody @Valid RolesMenuDto rolesMenuDto){  
                                                              
        APIResponse response = rolesMenuService.updtRolesMenu(id, rolesMenuDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    
}
