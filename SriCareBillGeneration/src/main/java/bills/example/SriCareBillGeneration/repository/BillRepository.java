package bills.example.SriCareBillGeneration.repository;

import bills.example.SriCareBillGeneration.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    Optional<Bill> findById(Integer billId);
}
