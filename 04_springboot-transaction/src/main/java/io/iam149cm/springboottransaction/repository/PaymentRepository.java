package io.iam149cm.springboottransaction.repository;

import io.iam149cm.springboottransaction.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
