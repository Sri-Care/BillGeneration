package bills.example.SriCareBillGeneration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Date paymentDate;
    private Time paymentTime;
    private Integer paymentAmount;
    private Integer billId;
    private Date billDate;
}
