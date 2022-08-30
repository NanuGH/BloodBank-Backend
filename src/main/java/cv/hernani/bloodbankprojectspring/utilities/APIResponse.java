package cv.hernani.bloodbankprojectspring.utilities;

import lombok.*;

import java.util.List;

@Data
@Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class APIResponse {

    private boolean status;
    private String message;
    private List<Object> details;

}
