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
    private LocalDate subscribedDate;
    private LocalDate cancellationDate;


//    @Column(columnDefinition = "varchar(255) default InActive'")
    @Enumerated(EnumType.STRING)
    private SubscriptionStatus subscriptionStatus;

    @ManyToOne
    @JoinColumn(name = "serviceId", referencedColumnName = "serviceId" )
    private Service service;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId" )
    private UserInfo userInfo;

}

