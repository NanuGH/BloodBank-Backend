package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import cv.hernani.bloodbankprojectspring.dtos.SampleDto;
import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;
import cv.hernani.bloodbankprojectspring.models.EmployeeModel;
import cv.hernani.bloodbankprojectspring.models.SampleModel;
import cv.hernani.bloodbankprojectspring.repositories.BloodCollectionRepository;
import cv.hernani.bloodbankprojectspring.repositories.EmployeeRepository;
import cv.hernani.bloodbankprojectspring.repositories.SampleRepository;
import cv.hernani.bloodbankprojectspring.service.service.SampleService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class SampleServiceImpl implements SampleService {

    final SampleRepository sampleRepository;
    final BloodCollectionRepository bloodCollectRepository;
    final EmployeeRepository employeeRepository;

    public SampleServiceImpl(SampleRepository sampleRepository, 
                             BloodCollectionRepository bloodCollectRepository,
                             EmployeeRepository employeeRepository) {
        this.sampleRepository = sampleRepository;
        this.bloodCollectRepository = bloodCollectRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public APIResponse createSample(@RequestBody @Valid SampleDto sampleDto, UUID idCollection, UUID idEmployee) {
        Optional<BloodCollectionModel> bloodCollectOptional = bloodCollectRepository.findById(idCollection);
        if (!bloodCollectOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Colheita não existe!")).build();
        }

        boolean sampleOptional = sampleRepository.existsBySampleNumber(sampleDto.getSampleNumber());
        if (sampleOptional == true) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Esta amostra já existe!")).build();
        }
        Optional<EmployeeModel> employeeModelOptional = employeeRepository.findById(idEmployee);

        var sampleModel = new SampleModel();
        try {
            BeanUtils.copyProperties(sampleDto, sampleModel);
            sampleModel.setIdEmployee(employeeModelOptional.get());
            sampleModel.setIdCollection(bloodCollectOptional.get());
            sampleModel.setWhoInserted(employeeModelOptional.get().getIdentifNumber());
            sampleModel.setWhoUpdated(null);
            sampleModel.setDmCodeDisabled(null);
            sampleModel.setStatus(true);
            sampleRepository.save(sampleModel);

            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }
    }

    @Override
    public APIResponse updateSample(UUID id, SampleDto sampleDto) {

        Optional<SampleModel> sampleOptional = sampleRepository.findById(id);
        if (!sampleOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Amostra não existe!")).build();
        }
        var sample = sampleOptional.get();

        try {
            BeanUtils.copyProperties(sampleDto, sample);
            sample.setExpirationDate(sampleDto.getExpirationDate());
            sample.setDmCodeDisabled(sampleOptional.get().getDmCodeSample());
            sample.setWhoInserted(sampleOptional.get().getWhoInserted());
            sample.setWhoUpdated(sampleDto.getWhoUpdated());
            sampleRepository.save(sample);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR)
                                        .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getAllSample() {
        List<SampleModel> getAllSample = sampleRepository.findAll();
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(
                    Arrays.asList(getAllSample)).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays
                    .asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getSampleById(UUID id) {
        if (!sampleRepository.existsById(id)) {
            return APIResponse.builder().status(false)
                    .details(Arrays.asList("Conflict: Amostra não existe!")).build();
        }
        Optional<SampleModel> sampleModel = sampleRepository.findById(id);
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(
                    Arrays.asList(sampleModel)).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays
                    .asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse changeStatus(UUID id) {
        Optional<SampleModel> sampleOptional = sampleRepository.findById(id);
        if (!sampleOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: Esta amostra não existe!")).build();
        }
        var bloodCollectModel = sampleOptional.get();
        try {
            bloodCollectModel.setStatus(false);
            sampleRepository.save(bloodCollectModel);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_REMOVER)
            .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getBySampleNumber(String sampleNumber) {
        try {
            Optional<SampleModel> getSampleNumber = sampleRepository.findBySampleNumber(sampleNumber);

            if (!getSampleNumber.isPresent()) {
                return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                        .details(Arrays.asList("ERRO: Esta amostra não existe!")).build();
            } else {
                return APIResponse.builder().status(true).message(MessageState.SUCESSO)
                        .details(Arrays.asList(getSampleNumber))
                        .build();
            }

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage()))
                    .build();
        }
    }
}