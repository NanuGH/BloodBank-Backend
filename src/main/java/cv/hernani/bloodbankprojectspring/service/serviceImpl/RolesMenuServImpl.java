package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.RolesMenuDto;
import cv.hernani.bloodbankprojectspring.models.MenuModel;
import cv.hernani.bloodbankprojectspring.models.RolesMenuModel;
import cv.hernani.bloodbankprojectspring.models.RolesModel;
import cv.hernani.bloodbankprojectspring.repositories.MenuRepository;
import cv.hernani.bloodbankprojectspring.repositories.RolesMenuRepository;
import cv.hernani.bloodbankprojectspring.repositories.RolesRepository;
import cv.hernani.bloodbankprojectspring.service.service.RoleMenuService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class RolesMenuServImpl implements RoleMenuService {

    final RolesRepository rolesRepository;
    final MenuRepository menuRepository;
    final RolesMenuRepository rolesMenuRepository;

    public RolesMenuServImpl(RolesRepository rolesRepository, MenuRepository menuRepository,
            RolesMenuRepository rolesMenuRepository) {
        this.rolesRepository = rolesRepository;
        this.menuRepository = menuRepository;
        this.rolesMenuRepository = rolesMenuRepository;
    }

    @Override
    public APIResponse createRolesMenu(RolesMenuDto rolesMenuDto, UUID idRoles, UUID idMenu) {
        var rolesMenuModel = new RolesMenuModel();
        Optional<RolesModel> rolesModelOptional = rolesRepository.findById(idRoles);
        Optional<MenuModel> menuModelOptional = menuRepository.findById(idMenu);

        try {
            BeanUtils.copyProperties(rolesMenuDto,rolesMenuModel);
            rolesMenuModel.setIdRoles(rolesModelOptional.get());
            rolesMenuModel.setIdMenu(menuModelOptional.get());
            rolesMenuRepository.save(rolesMenuModel);
            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }

    }

    @Override
    public APIResponse updtRolesMenu(UUID id, RolesMenuDto rolesMenuDto) {
        Optional<RolesMenuModel> rolesMenuOptional = rolesMenuRepository.findById(id);
        if (!rolesMenuOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: Este RoleMenu não existe!")).build();
        }
        var rolesMenuModel = rolesMenuOptional.get();

        try {
            BeanUtils.copyProperties(rolesMenuOptional, rolesMenuModel);
            rolesMenuRepository.save(rolesMenuModel);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();
            
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();
        }  
    }

    @Override
    public APIResponse getAllRolesMenu() {
        List<RolesMenuModel> getAllRolesMenu = rolesMenuRepository.findAll();
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(getAllRolesMenu)).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getRolesMenuById(UUID id) {
        if (!rolesMenuRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("ERRO: Este RoleMenu não existe!")).build();
        }
        Optional<RolesMenuModel> rolesMenuModel = rolesMenuRepository.findById(id);
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(rolesMenuModel)).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse delRolesMenu(UUID id) {
        if (!rolesMenuRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("ERRO: Este RoleMenu não existe!")).build();
        }
        try {
            rolesMenuRepository.deleteById(id);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).details(Arrays.asList(e.getMessage())).build();
        }
    }
    
}
