package cv.hernani.bloodbankprojectspring.dtos;

import lombok.Data;

@Data
public class DomainDto {

    //@Size(max = 15)
    private String domain;

   // @Size(max = 15)
    private String dmName;

   // @Size(max = 5)
    private String dmCode;

    //@Size(max = 2)
    private String dmOrder;

    //@Size(max = 2)
    private String selfId;
    
}
