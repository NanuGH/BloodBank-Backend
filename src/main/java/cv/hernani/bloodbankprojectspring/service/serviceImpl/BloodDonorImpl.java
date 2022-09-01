package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.BloodDonorDto;
import cv.hernani.bloodbankprojectspring.service.service.BloodDonorService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

@Service
public class BloodDonorImpl implements BloodDonorService{

    @Override
    public APIResponse createBloodDonor(BloodDonorDto bloodDonorDto, UUID idPerson) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public APIResponse updtBloodDonor(UUID id, BloodDonorDto bloodDonorDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public APIResponse getAllBloodDonor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public APIResponse getBloodDonorById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public APIResponse delBloodDonor(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
