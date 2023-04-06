package io.iam149cm.springboottransaction.repository;

import io.iam149cm.springboottransaction.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
