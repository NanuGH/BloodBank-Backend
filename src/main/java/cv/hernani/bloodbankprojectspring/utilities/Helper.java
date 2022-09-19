package cv.hernani.bloodbankprojectspring.utilities;

import java.sql.Date;
import java.time.LocalDate;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Helper {


    public static String identfNumberGenerator(){
        /*Random random = new Random();
        int number = random.nextInt(000,999);*/
        String randomString = RandomStringUtils.randomAlphanumeric(6);
        return randomString;
    }

    @Bean
    public static PasswordEncoder passEncoder(){
        return new BCryptPasswordEncoder();

    }

    public static LocalDate convertStringLocalDate(String localDate){
        LocalDate formatter =  LocalDate.parse(localDate);
        //convert String to LocalDate
        return formatter;
    }

}
