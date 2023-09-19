package bills.example.SriCareBillGeneration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue
    private Integer serviceId;
    private String serviceName;
    private Integer chargePerMonth;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<UserService> userService = new HashSet<>();
}

