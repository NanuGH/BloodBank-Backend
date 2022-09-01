package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.dtos.PersonRejectedDto;
import cv.hernani.bloodbankprojectspring.models.PersonRejectedModel;
import cv.hernani.bloodbankprojectspring.repositories.PersonRejectedRepository;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;
import cv.hernani.bloodbankprojectspring.service.service.PersonRejectedService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class PersonRejectedServImpl implements PersonRejectedService {

    final PersonRejectedRepository personRejectedRepository;
    final PersonRepository personRepository;

    public PersonRejectedServImpl(PersonRejectedRepository personRejectedRepository,
            PersonRepository personRepository) {
        this.personRejectedRepository = personRejectedRepository;
        this.personRepository = personRepository;
    }

    @Override
    public APIResponse createPersonRejected(PersonRejectedDto personRejectedDto, UUID idPerson) {
        Optional<PersonRejectedModel> personRejectModelOptional = personRejectedRepository.findById(idPerson);
        if (!personRejectModelOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("ERRO: Essa pessoa não existe na BD!"))
                    .build();
        }
        
        var personRejectedModel = new PersonRejectedModel();

        try {
            BeanUtils.copyProperties(personRejectedDto,personRejectedModel);
            personRejectedModel.setIdPerson(personRejectModelOptional.get().getIdPerson());
            personRejectedModel.setWhoInserted(personRejectedDto.getWhoInserted());
            personRejectedModel.setWhoUpdated(personRejectedDto.getWhoUpdated());
            personRejectedRepository.save(personRejectedModel);
            
            return APIResponse.builder().status(true).message(MessageState.INSERIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).build();
        }
    }

    @Override
    public APIResponse updtPersonRejected(UUID id, PersonRejectedDto personRejectedDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public APIResponse getAllPersonRejected() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public APIResponse getPersonRejectedById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public APIResponse delPersonRejected(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
