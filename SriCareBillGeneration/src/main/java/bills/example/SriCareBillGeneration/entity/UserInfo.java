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
@Table(name = "userInfo")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String email;
    private String password;
    private String roles;

    @OneToMany(mappedBy = "userInfo")
    private Set<UserService> userServices = new HashSet<>();

    @OneToMany(mappedBy = "userInfo")
    private Set<Bill> bills = new HashSet<>();

    @OneToMany(mappedBy = "userInfo")
    private Set<Payment> payments = new HashSet<>();


}
