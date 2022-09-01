package cv.hernani.bloodbankprojectspring.service.service;

import java.util.UUID;

import cv.hernani.bloodbankprojectspring.dtos.PersonRejectedDto;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;

public interface PersonRejectedService {
    public APIResponse createPersonRejected(PersonRejectedDto personRejectedDto, UUID idPerson);
    public APIResponse updtPersonRejected(UUID id, PersonRejectedDto personRejectedDto);
    public APIResponse getAllPersonRejected();
    public APIResponse getPersonRejectedById(UUID id);
    public APIResponse delPersonRejected(UUID id);
}
