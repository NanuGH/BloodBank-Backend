package cv.hernani.bloodbankprojectspring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@OpenAPIDefinition
@RestController
public class BloodBankspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankspringApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Ola Mundo";
	}

}
