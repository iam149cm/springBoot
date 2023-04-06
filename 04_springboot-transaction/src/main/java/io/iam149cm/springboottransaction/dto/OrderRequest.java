package io.iam149cm.springboottransaction.dto;

import io.iam149cm.springboottransaction.entity.Order;
import io.iam149cm.springboottransaction.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
