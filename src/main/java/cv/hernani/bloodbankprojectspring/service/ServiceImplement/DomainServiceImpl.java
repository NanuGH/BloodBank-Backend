package cv.hernani.bloodbankprojectspring.service.ServiceImplement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import cv.hernani.bloodbankprojectspring.dtos.DomainDto;
import cv.hernani.bloodbankprojectspring.models.DomainModel;
import cv.hernani.bloodbankprojectspring.repositories.DomainRepository;
import cv.hernani.bloodbankprojectspring.service.DomainService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Service
public class DomainServiceImpl implements DomainService {

     private final DomainRepository domainRepository;
    
     public DomainServiceImpl(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }    


    @Override
    public APIResponse createDomain(@RequestBody @Valid DomainDto domainDto) {
        if(domainRepository.existsByDomainAndDmCode(domainDto.getDomain(), domainDto.getDmCode())){
            return APIResponse.builder().status(false)
            .message(MessageState.ERRO_DE_INSERCAO)
            .details(Arrays.asList("Conflict: Domain already exists on DB!"))
            .build();
        }        
        var domainModel = new DomainModel();
        BeanUtils.copyProperties(domainDto, domainModel);
        try {
            domainRepository.saveAndFlush(domainModel);   
            return APIResponse.builder().status(true)
            .message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder()
            .status(false).message(MessageState.ERRO_DE_INSERCAO)
            .details(Arrays.asList(e.getMessage())).build();
        }
        
    }


    @Override
    public APIResponse getDomain() {
        List<DomainModel> getAll = domainRepository.findAll();
        try {           
            return APIResponse.builder().status(true)
            .message(MessageState.SUCESSO)
            .details(Arrays.asList(getAll)).build();
        } catch (Exception e) {
            return APIResponse.builder()
            .status(false).message(MessageState.ERRO)
            .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public void deleteDomain(UUID id) {
        domainRepository.deleteById(id);
    }

    @Override
    public APIResponse deletDomain(UUID id) {
        if(!domainRepository.existsById(id)){
            return APIResponse.builder().status(false)
            .details(Arrays.asList("Conflict: Domain dont exists on DB!"))
            .build();
        }
        try {
            domainRepository.deleteById(id);
            return APIResponse.builder().status(true)
            .message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false)
            .details(Arrays.asList(e.getMessage())).build();
        }
    }


   
}
