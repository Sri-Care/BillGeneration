package bills.example.SriCareBillGeneration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue
    private Integer paymentId;
    private LocalDate paymentDate;
    private LocalTime paymentTime;
    private Integer paymentAmount;

    @OneToOne
    @JoinColumn(name = "billId", referencedColumnName = "billId" )
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId" )
    private UserInfo user;

}
