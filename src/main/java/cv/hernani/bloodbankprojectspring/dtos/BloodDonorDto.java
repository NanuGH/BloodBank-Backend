package cv.hernani.bloodbankprojectspring.dtos;

import lombok.Data;

@Data
public class BloodDonorDto {
    
    private String dmBloodGroup;
    private String dmTypeDonor;
    private String personalBackground;//antecedentes pessoais
    private String clinicalExam;
    private String physicalExam;
    private boolean summoned;//convocado
    private boolean celFalcif;
    private String Phenotype;
    private String dmHemolisina;
}
