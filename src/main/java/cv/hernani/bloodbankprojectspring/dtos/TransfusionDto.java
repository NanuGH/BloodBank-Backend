package cv.hernani.bloodbankprojectspring.dtos;

import lombok.Data;

@Data
public class TransfusionDto {
    
    private boolean suspended;
    private String suspDate;
    private boolean suspReason;
    private String transfRest; 
    private String transfRestDate;
    private String obsTransfRest;
    private String drip;//gotejo
    private String nursery;
    private String room;
    private String bed;
    private String dmParamChanged;
    private String dmTranSymptom;
    private String appliedTherapy;
    private String whoUpdated;
    private String whoInserted;
}
