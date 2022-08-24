package cv.hernani.bloodbankprojectspring.service.ServiceImplement;

public class PersonServiceImpl {

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