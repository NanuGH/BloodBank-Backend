package cv.hernani.bloodbankprojectspring.utilities;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class APIResponse {

    private boolean status;
    private String message;
    private List<Object> details;

}
