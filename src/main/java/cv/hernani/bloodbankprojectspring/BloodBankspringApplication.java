package cv.hernani.bloodbankprojectspring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
//https://www.digitalocean.com/community/tutorials/spring-boot-cannot-determine-embedded-database-driver-class-for-database-type-none
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@OpenAPIDefinition
@RestController
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class BloodBankspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankspringApplication.class, args);
	}

}
