package bills.example.SriCareBillGeneration.repository;

import bills.example.SriCareBillGeneration.entity.UserService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserServiceRepository extends JpaRepository<UserService, Integer> {
}
