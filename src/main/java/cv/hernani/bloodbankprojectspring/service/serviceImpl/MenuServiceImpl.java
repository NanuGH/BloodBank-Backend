package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.MenuDto;
import cv.hernani.bloodbankprojectspring.models.MenuModel;
import cv.hernani.bloodbankprojectspring.repositories.MenuRepository;
import cv.hernani.bloodbankprojectspring.service.service.MenuService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class MenuServiceImpl implements MenuService {

    final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public APIResponse createMenu(MenuDto menuDto) {
        if(menuRepository.existsByName(menuDto.getName())){
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Este menu já existe na BD!")).build();
        }
        try {
            var menuModel = new MenuModel();
            BeanUtils.copyProperties(menuDto, menuModel);
            menuRepository.save(menuModel);
            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }
    }

    @Override
    public APIResponse updtMenu(UUID id, MenuDto menuDto) {
        Optional<MenuModel> menuModelOptional = menuRepository.findById(id);
        if (!menuModelOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Esta pessoa não existe na BD!"))
                    .build();
        }
        var menuModel = menuModelOptional.get();       

        try {
            BeanUtils.copyProperties(menuDto, menuModel);
            menuModel.setId(menuModelOptional.get().getId());
            menuModel.setStatus(menuModelOptional.get().getStatus());
            menuRepository.save(menuModel);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();

        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO_AO_ATUALIZAR)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getAllMenu() {
        List<MenuModel> getAllMenu = menuRepository.findAll();
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(getAllMenu)).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getMenuById(UUID id) {
        if (!menuRepository.existsById(id)) { 
            return APIResponse.builder().status(false).details(Arrays.asList("ERRO: Este Menu não existe na BD!")).build();
         }
         Optional<MenuModel> menuModel = menuRepository.findById(id);
         try {
             return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(menuModel)).build();
 
         } catch (Exception e) {
             return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
         }
    }

    @Override
    public APIResponse deleteMenu(UUID id) {
        if (!menuRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("ERRO: Este Menu não existe na BD!!"))
                    .build();
        }
        try {
            menuRepository.deleteById(id);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).details(Arrays.asList(e.getMessage())).build();
        }
    }
    
}
