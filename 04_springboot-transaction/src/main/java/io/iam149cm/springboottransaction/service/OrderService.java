package io.iam149cm.springboottransaction.service;

import io.iam149cm.springboottransaction.dto.OrderRequest;
import io.iam149cm.springboottransaction.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);


}
