package bills.example.SriCareBillGeneration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDTO {
    private Integer serviceId;
    private String serviceName;
    private Integer chargePerMonth;

}
