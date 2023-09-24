package bills.example.SriCareBillGeneration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue
    private Integer billId;
    private Integer totalAmount;
    private LocalDate billDate;
    //private LocalDate dueDate;
    @OneToOne(mappedBy = "bill")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId" )
    private UserInfo user;

}
