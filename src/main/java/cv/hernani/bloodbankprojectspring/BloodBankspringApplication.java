package cv.hernani.bloodbankprojectspring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
@OpenAPIDefinition
public class BloodBankspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankspringApplication.class, args);
	}

}
