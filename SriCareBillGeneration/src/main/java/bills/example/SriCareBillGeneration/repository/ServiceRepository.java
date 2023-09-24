package bills.example.SriCareBillGeneration.repository;

import bills.example.SriCareBillGeneration.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
