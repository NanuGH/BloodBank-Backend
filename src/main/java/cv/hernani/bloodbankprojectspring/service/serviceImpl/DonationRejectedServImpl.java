package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.DonationRejectedDto;
import cv.hernani.bloodbankprojectspring.models.BloodCollectionModel;
import cv.hernani.bloodbankprojectspring.models.DonationRejectedModel;
import cv.hernani.bloodbankprojectspring.repositories.BloodCollectionRepository;
import cv.hernani.bloodbankprojectspring.repositories.DonationRejectedRepository;
import cv.hernani.bloodbankprojectspring.service.service.DonationRejectedService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class DonationRejectedServImpl implements DonationRejectedService{

    
    final DonationRejectedRepository donationRejectedRepository;
    final BloodCollectionRepository bloodCollectionRepository;
    public DonationRejectedServImpl(DonationRejectedRepository donationRejectedRepository,BloodCollectionRepository bloodCollectionRepository) {
        this.donationRejectedRepository = donationRejectedRepository;
        this.bloodCollectionRepository = bloodCollectionRepository;
    }

    @Override
    public APIResponse createDonationRejected(DonationRejectedDto donationRejectedDto, UUID idBloodCollect) {
        Optional<BloodCollectionModel> bloodCollectModelOptional = bloodCollectionRepository.findById(idBloodCollect);
        if (!bloodCollectModelOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Esta Colheita não existe na BD!"))
                    .build();
        }
        
        var donationRejectedModel = new DonationRejectedModel();

        try {
            BeanUtils.copyProperties(donationRejectedDto,donationRejectedModel);
            donationRejectedModel.setIdBloodCollect(bloodCollectModelOptional.get());
            donationRejectedModel.setWhoInserted(donationRejectedDto.getWhoInserted());
            donationRejectedModel.setWhoUpdated(donationRejectedDto.getWhoUpdated());
            donationRejectedRepository.save(donationRejectedModel);
            
            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }
    }

    @Override
    public APIResponse updtDonationRejected(UUID id, DonationRejectedDto donationRejectedDto) {
        Optional<DonationRejectedModel> donationRejectedOptional = donationRejectedRepository.findById(id);
        if (!donationRejectedOptional.isPresent()) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: Esta rejeição nao existe na BD!")).build();
        }
        var donationRejectedModel = donationRejectedOptional.get();   

        try {
            BeanUtils.copyProperties(donationRejectedDto, donationRejectedModel);
            donationRejectedModel.setRejectionCollectCode(donationRejectedDto.getRejectionCollectCode());
            donationRejectedModel.setWhoUpdated(donationRejectedDto.getWhoUpdated());
            donationRejectedRepository.save(donationRejectedModel);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();
        }  
    }

    @Override
    public APIResponse getAllDonationRejected() {
        List<DonationRejectedModel> getAllPersonRejected = donationRejectedRepository.findAll();
        try {
            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(getAllPersonRejected)).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getDonationRejectedById(UUID id) {
        if (!donationRejectedRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("ERRO: Esta Rejeição não existe na BD!")).build();
        }
        Optional<DonationRejectedModel> donationRejectedModel = donationRejectedRepository.findById(id);
        try {

            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(donationRejectedModel)).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse delDonationRejected(UUID id) {
        if (!donationRejectedRepository.existsById(id)) {
            return APIResponse.builder().status(false).details(Arrays.asList("ERRO: Esta Rejeição não existe na BD!!")).build();
        }
        try {
            donationRejectedRepository.deleteById(id);
            return APIResponse.builder().status(true).message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).details(Arrays.asList(e.getMessage())).build();
        }
    }
    
}
