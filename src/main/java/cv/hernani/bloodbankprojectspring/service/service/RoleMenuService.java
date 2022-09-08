package cv.hernani.bloodbankprojectspring.service.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.RolesMenuDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface RoleMenuService {

    public APIResponse createRolesMenu(RolesMenuDto rolesMenuDto, UUID idRoles, UUID idMenu);
    public APIResponse updtRolesMenu(UUID id, RolesMenuDto rolesMenuDto);
    public APIResponse getAllRolesMenu();
    public APIResponse getRolesMenuById(UUID id);
    public APIResponse delRolesMenu(UUID id);
    
}
