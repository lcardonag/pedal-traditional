package redhat.engineering.ebikes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import redhat.engineering.ebikes.entities.Order;
import redhat.engineering.ebikes.repositories.OrderRepository;

import jakarta.persistence.*;
import jakarta.transaction.*;
import java.util.List;

@Service
@Configurable
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public List<Order> retrieveOrders() {
        return orderRepository.findAll();
    }
}