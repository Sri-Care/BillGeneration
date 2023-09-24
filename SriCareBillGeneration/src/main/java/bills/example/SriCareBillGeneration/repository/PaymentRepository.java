package bills.example.SriCareBillGeneration.repository;

import bills.example.SriCareBillGeneration.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
