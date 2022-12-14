package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import cv.hernani.bloodbankprojectspring.dtos.DomainDto;
import cv.hernani.bloodbankprojectspring.models.DomainModel;
import cv.hernani.bloodbankprojectspring.repositories.DomainRepository;
import cv.hernani.bloodbankprojectspring.service.service.DomainService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class DomainServiceImpl implements DomainService {

    private final DomainRepository domainRepository;

    public DomainServiceImpl(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    //@Transactional
    //@Override
    /*public APIResponse createDomain(@RequestBody @Valid DomainDto domainDto) {
        if (domainRepository.existsByDomainAndDmCode(domainDto.getDomain(), domainDto.getDmCode())) {
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

    } */

    /* @Transactional
    @Override
    public APIResponse createDomain(@RequestBody @Valid DomainDto domainDto) {
        if (domainRepository.existsByDomainAndDmCode(domainDto.getDomain(), domainDto.getDmCode())) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("Conflict: Domain already exists on DB!"))
                    .build();
        }
        List<DomainModel> dModelOptnal = domainRepository.findByDomain(domainDto.getDomain());
        var domainModel = new DomainModel();
        
        try {
            UUID selfid = UUID.randomUUID();
            if(dModelOptnal.isEmpty()){
                BeanUtils.copyProperties(domainDto, domainModel);
                domainModel.setDmOrder(0);
                domainModel.setSelfId(null);
                domainRepository.saveAndFlush(domainModel);
                return APIResponse.builder().status(true)
                                  .message(MessageState.INSERIDO_COM_SUCESSO).build();
            }else{
                for (int i = 0; i <= dModelOptnal.size(); i++) {
                    int order = 0;
                    if (order == dModelOptnal.get(i).getDmOrder()) {
                        selfid = dModelOptnal.get(i).getIdDomain();
                        System.out.println("selfid="+ selfid);
                        System.out.println("Ordem=" + dModelOptnal.get(i).getDmOrder());
                    }
                }

                for(DomainModel x: dModelOptnal) {

                }

                dModelOptnal.stream()
                .map(x=>{


                }
                return x;
                )
                .Colle

                BeanUtils.copyProperties(domainDto, domainModel);
                domainModel.setDmOrder(dModelOptnal.size());
                domainModel.setSelfId(selfid);
                domainRepository.saveAndFlush(domainModel);
                return APIResponse.builder().status(true)
                                  .message(MessageState.INSERIDO_COM_SUCESSO).build();
            }
            
        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    } */
   
    
    @Transactional
    @Override
    public APIResponse createDomain(@RequestBody @Valid DomainDto domainDto) {
        if (domainRepository.existsByDomainAndDmCode(domainDto.getDomain(), domainDto.getDmCode())) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("Conflict: Domain already exists on DB!"))
                    .build();
        }
        Optional<DomainModel> dModelOptnal = domainRepository.findByDomainAndSelfIdIsNull(domainDto.getDomain());
        var domainModel = new DomainModel();
        
        try {
            
            if(!dModelOptnal.isPresent()){
                BeanUtils.copyProperties(domainDto, domainModel);
                domainModel.setDmOrder(0);
                domainModel.setSelfId(null);
                domainRepository.saveAndFlush(domainModel);
                return APIResponse.builder().status(true)
                                  .message(MessageState.INSERIDO_COM_SUCESSO).build();
            }else{
                
                BeanUtils.copyProperties(domainDto, domainModel);
                domainModel.setDmOrder((domainRepository.countByDomainAndSelfIdIsNotNull(domainDto.getDomain())+1));
                domainModel.setSelfId(dModelOptnal.get().getIdDomain());
                domainRepository.saveAndFlush(domainModel);
                return APIResponse.builder().status(true)
                                  .message(MessageState.INSERIDO_COM_SUCESSO).build();
            }
            
        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }
   
   
    @Transactional
    @Override
    public APIResponse updateDomain(UUID id, @RequestBody @Valid DomainDto domainDto) {
        Optional<DomainModel> domainModelOptional = domainRepository.findById(id);
        if (!domainModelOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("Conflict: Domain don't exists on DB!"))
                    .build();
        }
        var domainModel = new DomainModel();       

        try {
            BeanUtils.copyProperties(domainDto, domainModel);
            domainModel.setIdDomain(domainModelOptional.get().getIdDomain());
            domainRepository.save(domainModel);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();

        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO_AO_ATUALIZAR)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getAllDomain() {
        List<DomainModel> getAll = domainRepository.findAll();
        try {
            return APIResponse.builder().status(true)
                    .message(MessageState.SUCESSO)
                    .details(Arrays.asList(getAll.toArray())).build();//toArray [[]] passa a ser []
        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse findByDomain(String domain) {
        List<DomainModel> getDomain = new ArrayList<>();        
        try {           
            if (domain != "" && domain != null) {
                getDomain = domainRepository.findByDomain(domain);
                return APIResponse.builder().status(true)
                .message(MessageState.SUCESSO)
                .details(Arrays.asList(getDomain.toArray())).build();
            }           
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage()))
                    .build();
        }
        return null;
    }

    @Override
    public APIResponse findBySelfId(UUID selfId) {
        List<DomainModel> getDomain = new ArrayList<>();        
        try {           
            if (selfId == null) {
                getDomain = domainRepository.findBySelfId(selfId);
                return APIResponse.builder().status(true)
                                  .message(MessageState.SUCESSO)
                                  .details(Arrays.asList(getDomain.toArray())).build();
            }           
        } catch (Exception e) {
            return APIResponse.builder().status(false)
                                        .message(MessageState.ERRO)
                                        .details(Arrays.asList(e.getMessage())).build();
        }
        return null;
    }

    @Override
    public APIResponse getDomainById(UUID id) {
        if (!domainRepository.existsById(id)) {
            return APIResponse.builder().status(false)
                    .details(Arrays.asList("Conflict: Domain dont exists on DB!"))
                    .build();
        }
        Optional<DomainModel> domainModel = domainRepository.findById(id);
        try {

            return APIResponse.builder().status(true)
                    .message(MessageState.SUCESSO)
                    .details(Arrays.asList(domainModel)).build();

        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse deleteDomain(UUID id) {
        if (!domainRepository.existsById(id)) {
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
