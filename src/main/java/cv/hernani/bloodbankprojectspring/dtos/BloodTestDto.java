package cv.hernani.bloodbankprojectspring.dtos;

import lombok.Data;

@Data
public class BloodTestDto {
    private Boolean vdrl;
    private Boolean hiv;
    private Boolean aghbs;
    private Boolean hcv;
    private String clinicalConc;
    private String obs;
}
