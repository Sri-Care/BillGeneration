package bills.example.SriCareBillGeneration.repository;

import bills.example.SriCareBillGeneration.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
