package cv.hernani.bloodbankprojectspring.service.serviceImpl;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.RolesDto;
import cv.hernani.bloodbankprojectspring.models.RolesModel;
import cv.hernani.bloodbankprojectspring.repositories.RolesRepository;
import cv.hernani.bloodbankprojectspring.service.service.RolesService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class RolesServiceImpl implements RolesService {

    final RolesRepository rolesRepository;

    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public APIResponse createRoles(RolesDto rolesDto) {
        if (rolesRepository.existsByName(rolesDto.getName())){
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: Este Role já existe na BD!")).build();
        }          
        var rolesModel = new RolesModel();
        BeanUtils.copyProperties(rolesDto, rolesModel);
        rolesModel.setStatus("true");
        try {
            rolesRepository.saveAndFlush(rolesModel);
            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList(e.getMessage())).build();
        }
    
    }

    @Override
    public APIResponse getAllRoles() {
        List<RolesModel> getAllRoles = rolesRepository.findAll();
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(getAllRoles)).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getRolesById(UUID id) {
        if (!rolesRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("ERRO: Este Role não existe na BD!!")).build();
        }
        Optional<RolesModel> rolesModel = rolesRepository.findById(id);
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(rolesModel)).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse deleteRoles(UUID id) {
        if (!rolesRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("ERRO: Este Role não existe na BD!")).build();
        }
        try {
            rolesRepository.deleteById(id);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse updateRoles(UUID id, RolesDto rolesDto) {
        Optional<RolesModel> rolesModelOptional = rolesRepository.findById(id);
        if (!rolesModelOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: Este Role não existe na BD!")).build();
        }
        var rolesModel = rolesModelOptional.get();

        try {
            BeanUtils.copyProperties(rolesModelOptional, rolesModel);
                rolesModel.setName(rolesDto.getName());
                rolesModel.setCode(rolesDto.getCode());
                rolesModel.setMenu(rolesDto.getMenu());
                rolesModel.setWhoUpdated(rolesDto.getWhoUpdated());
                rolesModel.setWhoInserted(rolesModelOptional.get().getWhoInserted());                

                rolesRepository.save(rolesModel);
                return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();
            
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();
        }    
    }
}