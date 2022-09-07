package cv.hernani.bloodbankprojectspring.controllers;

import org.springframework.web.bind.annotation.*;
import cv.hernani.bloodbankprojectspring.dtos.MenuDto;
import cv.hernani.bloodbankprojectspring.service.service.MenuService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/menu")
public class MenuController {
    
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createMenu(@Valid @RequestBody MenuDto menuDto) {
        APIResponse response = menuService.createMenu(menuDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Object> getAllMenu() {
        APIResponse response = menuService.getAllMenu();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<Object> getRolesById(@PathVariable("id") UUID id){
        APIResponse response = menuService.getMenuById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteRoles(@PathVariable("id") UUID id){
       APIResponse response = menuService.deleteMenu(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Object> updateRoles(@PathVariable("id") UUID id,@RequestBody @Valid MenuDto menuDto){
        APIResponse response = menuService.updtMenu(id, menuDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
