package bills.example.SriCareBillGeneration.repository;

import bills.example.SriCareBillGeneration.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
}
