package io.iam149cm.springboottransaction.service.impl;

import io.iam149cm.springboottransaction.dto.OrderRequest;
import io.iam149cm.springboottransaction.dto.OrderResponse;
import io.iam149cm.springboottransaction.entity.Order;
import io.iam149cm.springboottransaction.entity.Payment;
import io.iam149cm.springboottransaction.exception.PaymentException;
import io.iam149cm.springboottransaction.repository.OrderRepository;
import io.iam149cm.springboottransaction.repository.PaymentRepository;
import io.iam149cm.springboottransaction.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional // (rollbackFor = PaymentException.class)
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("PLACED");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment type is not supported");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("Order placed successfully");

        return orderResponse;
    }
}
