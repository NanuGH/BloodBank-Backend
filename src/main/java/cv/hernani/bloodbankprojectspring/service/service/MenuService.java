package cv.hernani.bloodbankprojectspring.service.service;

import java.util.UUID;
import cv.hernani.bloodbankprojectspring.dtos.MenuDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface MenuService {
    public APIResponse createMenu(MenuDto menuDto);
    public APIResponse updtMenu(UUID id, MenuDto menuDto);
    public APIResponse getAllMenu();
    public APIResponse getMenuById(UUID id);
    public APIResponse deleteMenu(UUID id);
}
