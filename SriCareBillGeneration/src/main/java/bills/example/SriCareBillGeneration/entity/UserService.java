package bills.example.SriCareBillGeneration.entity;

import bills.example.SriCareBillGeneration.enumeration.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_service")
public class UserService {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private LocalDate subscribedDate;
    private LocalDate cancellationDate;
    private SubscriptionStatus subscriptionStatus;

    @ManyToOne
    @JoinColumn(name = "serviceId", referencedColumnName = "serviceId" )
    private Service service;

}

