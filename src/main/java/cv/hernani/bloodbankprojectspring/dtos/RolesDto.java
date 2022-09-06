package cv.hernani.bloodbankprojectspring.dtos;

import lombok.Data;

@Data
public class RolesDto {
    private String name;
    private String code;
    private String[] menu;
    private String whoUpdated;
}
