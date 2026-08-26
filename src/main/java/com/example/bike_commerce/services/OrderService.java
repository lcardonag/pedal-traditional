package com.example.bike_commerce.services;

import com.example.bike_commerce.customers.entities.Order;
import com.example.bike_commerce.customers.repositories.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class OrderService {
    public OrderService() {}

    @Autowired
    OrderRepository orderRepository;

    @Transactional
    public List<Order> retrieveOrders() {
        return orderRepository.findAll();
    }
}