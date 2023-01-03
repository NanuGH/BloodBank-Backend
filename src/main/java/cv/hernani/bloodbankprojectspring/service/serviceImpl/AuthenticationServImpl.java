package cv.hernani.bloodbankprojectspring.service.serviceImpl;

import org.springframework.stereotype.Service;

import cv.hernani.bloodbankprojectspring.repositories.EmployeeRepository;
import cv.hernani.bloodbankprojectspring.repositories.RolesMenuRepository;
import cv.hernani.bloodbankprojectspring.repositories.RolesRepository;
import cv.hernani.bloodbankprojectspring.service.service.AuthenticationService;



@Service
public class AuthenticationServImpl implements AuthenticationService {

    final EmployeeRepository employeeRepository;
    final RolesMenuRepository rolesMenuRepository;
    final RolesRepository rolesRepository;


    public AuthenticationServImpl(EmployeeRepository employeeRepository, RolesMenuRepository rolesMenuRepository, RolesRepository rolesRepository) {
        this.employeeRepository = employeeRepository;
        this.rolesMenuRepository = rolesMenuRepository;
        this.rolesRepository = rolesRepository;
    }

   /*  @Override
    public APIResponse postAuthentication(AuthenticationDto authenticationDto) {
        if (!employeeRepository.existsByEmailAndPw(authenticationDto.getEmail(), authenticationDto.getPw())){
            return APIResponse.builder().status(false).message(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("ERRO: email ou pw incorreto!")).build();
        }

        //Optional<EmployeeModel> employeeModel = employeeRepository.findByEmail(authenticationDto.getEmail());
        List<EmployeeModel> employeeModel= employeeRepository.findByEmail(authenticationDto.getEmail());
        Optional<RolesModel> rolesOptional = rolesRepository.findById(employeeModel.get().getIdRole());
        List<RolesMenuModel> rolesMenuModel = rolesMenuRepository.findByIdRoles(rolesOptional.get());

        ArrayList<String> menu = new ArrayList<String>();
        for(RolesMenuModel rolmenuModel:rolesMenuModel){
            menu.add(rolmenuModel.getIdMenu().getCode());
        }

        try {

            AuthenticationResponseDto authenticationResponseDto = new   AuthenticationResponseDto();  
            
            authenticationResponseDto.setEmail(authenticationDto.getEmail());
            authenticationResponseDto.setName(employeeModel.get().getIdPerson().getNamePerson());
            authenticationResponseDto.setRoles(rolesOptional.get().getCode());
            authenticationResponseDto.setIdEmployee(employeeModel.get().getId());
            authenticationResponseDto.setMenu(menu);

            return APIResponse.builder().status(true).message(MessageState.SUCESSO).details(Arrays.asList(authenticationResponseDto)).build();

        } catch (Exception e) {
            return APIResponse.builder().status(false).message(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }
    } */
    
}