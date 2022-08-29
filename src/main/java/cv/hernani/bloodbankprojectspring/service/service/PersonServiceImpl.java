package cv.hernani.bloodbankprojectspring.service.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import cv.hernani.bloodbankprojectspring.dtos.PersonDto;
import cv.hernani.bloodbankprojectspring.models.PersonModel;
import cv.hernani.bloodbankprojectspring.repositories.PersonRepository;
import cv.hernani.bloodbankprojectspring.service.PersonService;
import cv.hernani.bloodbankprojectspring.utilities.APIResponse;
import cv.hernani.bloodbankprojectspring.utilities.MessageState;

@Service
public class PersonServiceImpl implements PersonService {

  final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    @Override
    public APIResponse createPerson(@RequestBody @Valid PersonDto personDto) {
      if (personRepository.existsByNamePersonAndSurnamePersonAndDmDocIdent(personDto.getNamePerson(),personDto.getSurnamePerson(),personDto.getDmDocIdent())){
        return APIResponse.builder().status(false)
                .message(MessageState.ERRO_DE_INSERCAO)
                .details(Arrays.asList("Conflict: Person already exists on DB!"))
                .build();
      }
      
        var personModel = new PersonModel();
        BeanUtils.copyProperties(personDto, personModel);
        try {
            personRepository.saveAndFlush(personModel);
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
    public APIResponse updatePerson(UUID id, @RequestBody @Valid PersonDto personDto) {
        Optional<PersonModel> domainModelOptional = personRepository.findById(id);
        if (!domainModelOptional.isPresent()) {
            return APIResponse.builder().status(false)
                    .message(MessageState.ERRO_DE_INSERCAO)
                    .details(Arrays.asList("Conflict: Domain don't exists on DB!"))
                    .build();
        }
        var personModel = new PersonModel();       

        try {
            BeanUtils.copyProperties(personDto, personModel);
            personModel.setId(domainModelOptional.get().getId());
            personRepository.save(personModel);
            return APIResponse.builder().status(true).message(MessageState.ATUALIZADO_COM_SUCESSO).build();

        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO_AO_ATUALIZAR)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse getAllPerson() {
        List<PersonModel> getAll = personRepository.findAll();
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
    public APIResponse getPersonById(UUID id) {
        if (!personRepository.existsById(id)) {
            return APIResponse.builder().status(false)
                    .details(Arrays.asList("Conflict: Domain dont exists on DB!"))
                    .build();
        }
        Optional<PersonModel> personModel = personRepository.findById(id);
        try {

            return APIResponse.builder().status(true)
                    .message(MessageState.SUCESSO)
                    .details(Arrays.asList(personModel)).build();

        } catch (Exception e) {
            return APIResponse.builder()
                    .status(false).message(MessageState.ERRO)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }

    @Override
    public APIResponse deletePerson(UUID id) {
        if (!personRepository.existsById(id)) {
            return APIResponse.builder().status(false)
                    .details(Arrays.asList("Conflict: Domain dont exists on DB!"))
                    .build();
        }
        try {
            personRepository.deleteById(id);
            return APIResponse.builder().status(true)
                    .message(MessageState.REMOVIDO_COM_SUCESSO).build();
        } catch (Exception e) {
            return APIResponse.builder().status(false)
                    .details(Arrays.asList(e.getMessage())).build();
        }
    }

}

/*public interface PessoaService {

    ResponseEntity<Object> criatePerson(PessoaDTO dto);

    ResponseEntity<Object> detailPerson(String id);}

     private final PessoaService pessoaService;

    private final PessoaRepository pessoaRepository;
    // criar construtor de injecao de interfaces

    @Service
    public class PessoaServiceImpl implement PessoaService{

   @Override
   public ResponseEntity<Object> criarPessoa(PessoaDTO dto) {

    try {
        Pessoa pessao = new Pessoa();
       
        pessoa.setName(dto.getNome());
        pessoa.setSurname(dto.getApelido());
        pessoa.setBirthDay(dto.getNascimento());

       pessoaRepository.save(pessoa);

       return new ResponseEntity<>("Sucesso")
    }catch(Execption e){

    return new ResponseEntity<>(e.getMessage)
    }

   }

   @Override
   public ResponseEntity<Object> detalherPessoa(String id) {

      Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
      if(!optionalPessoa.isPresent){
          return new ResponseEntity<>("Erro");
      }
        try {
        PessoaDTO dto = new PessoaDTO();       
        dto.setNome(dto.getName());
        dto.setApelido(dto.getSurname());
        dto.setNascimento(dto.getBirthDay());
        return new ResponseEntity<>(dto);
     }catch(Execption e){
      return new ResponseEntity<>(e.getMessage);
     }

   }
}*/