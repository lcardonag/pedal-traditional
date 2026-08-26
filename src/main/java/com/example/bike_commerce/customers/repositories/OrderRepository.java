package com.example.bike_commerce.customers.repositories;

import com.example.bike_commerce.customers.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
//    @Query(value = "SELECT * FROM bike_order INNER JOIN service_user ON bike_order WHERE service_user.id=?", nativeQuery = true)
//    List<Order> findOrdersByUserId(Long id);

//    @Query(value = "SELECT * FROM bike_order WHERE bike_order.customer_id = ?", nativeQuery = true)
//    List<Order> findOrdersByUserId(Long id);
}