package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.BloodDonorCreateDto;
import cv.hernani.bloodbankprojectspring.dtos.BloodDonorDto;
import cv.hernani.bloodbankprojectspring.dtos.BloodTestDto;
import cv.hernani.bloodbankprojectspring.models.BloodDonorModel;
import cv.hernani.bloodbankprojectspring.models.BloodTestModel;
import cv.hernani.bloodbankprojectspring.models.EmployeeModel;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.models.SampleModel;
import cv.hernani.bloodbankprojectspring.repositories.BloodDonorRepository;
import cv.hernani.bloodbankprojectspring.repositories.BloodTestRepository;
import cv.hernani.bloodbankprojectspring.repositories.EmployeeRepository;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;
import cv.hernani.bloodbankprojectspring.repositories.SampleRepository;
import cv.hernani.bloodbankprojectspring.service.service.BloodDonorService;
import cv.hernani.bloodbankprojectspring.service.service.BloodTestService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.Helper;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class BloodTestServiceImpl implements BloodTestService {

    final BloodDonorRepository bloodDonorRepository;
    final SampleRepository sampleRepository;
    final EmployeeRepository employeeRepository;
    final BloodTestRepository bloodTestRepository;

    public BloodTestServiceImpl(BloodDonorRepository bloodDonorRepository,
            SampleRepository sampleRepository,
            EmployeeRepository employeeRepository,
            BloodTestRepository bloodTestRepository) {
        this.bloodDonorRepository = bloodDonorRepository;
        this.sampleRepository = sampleRepository;
        this.employeeRepository = employeeRepository;
        this.bloodTestRepository = bloodTestRepository;
    }

    @Override
    public APIResponse createBloodTest(BloodTestDto bloodTestDto, UUID idEmployee, UUID idSample) {
        Optional<SampleModel> sampleOptional = sampleRepository.findById(idSample);
        if (!sampleOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Esta pessoa não existe na BD!"))
                    .build();
        }

        Optional<EmployeeModel> employeeModelOptional = employeeRepository.findById(idEmployee);
        if (!employeeModelOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Este funcionário não existe na BD")).build();
        }

        var testModel = new BloodTestModel();

        try {
            BeanUtils.copyProperties(bloodTestDto, testModel);
            testModel.setIdEmployee(employeeModelOptional.get());
            testModel.setWhoInserted(employeeModelOptional.get().getWhoInserted());
            testModel.setWhoUpdated(null);
            String dmCodeTest = Helper.identfNumberGenerator();
            testModel.setDmCodeTest(dmCodeTest);
            bloodTestRepository.save(testModel);

            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }

    }

    @Override
    public APIResponse updtBloodTest(UUID idDonner, UUID idEmpl, BloodTestDto bloodTestDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public APIResponse getAllBloodTest() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public APIResponse getBloodTestById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public APIResponse delBloodTest(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public APIResponse changeStatus(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

}
