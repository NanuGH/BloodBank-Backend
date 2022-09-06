package cv.hernani.bloodbankprojectspring.service.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.RolesDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface RolesService {
    public APIResponse createRoles(RolesDto rolesDto);
    public APIResponse getAllRoles();
    public APIResponse getRolesById(UUID id);
    public APIResponse deleteRoles(UUID id);
    public APIResponse updateRoles(UUID id, RolesDto rolesDto);
}
