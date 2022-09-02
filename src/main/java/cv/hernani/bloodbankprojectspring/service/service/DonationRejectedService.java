package cv.hernani.bloodbankprojectspring.service.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.DonationRejectedDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface DonationRejectedService {
    public APIResponse createDonationRejected(DonationRejectedDto donationRejectedDto, UUID idBloodCollect);
    public APIResponse updtDonationRejected(UUID id, DonationRejectedDto donationRejectedDto);
    public APIResponse getAllDonationRejected();
    public APIResponse getDonationRejectedById(UUID id);
    public APIResponse delDonationRejected(UUID id);
}
