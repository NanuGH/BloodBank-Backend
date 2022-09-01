package cv.hernani.bloodbankprojectspring.service.serviceImpl;

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

    @Transactional
    @Override
    public APIResponse createDomain(@RequestBody @Valid DomainDto domainDto) {
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
                    .details(Arrays.asList(getAll)).build();
        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO)
                    .details(Arrays.asList(e.getMessage())).build();
        }
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
