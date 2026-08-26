package com.example.bike_commerce.services;

import com.example.bike_commerce.customers.entities.Customer;
import com.example.bike_commerce.customers.repositories.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Configurable
public class CustomersService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Customer> retrieveUsers(String filterBy) {
        return customerRepository.findAll();
    }

    public Optional<Customer> retrieveAUser(Long userId) {
        return customerRepository.findById(userId);
    }

    public void deleteAUser(Long userId) {
        customerRepository.deleteById(userId);
    }

    @Transactional
    public void createUser(Customer customerData) {
        entityManager.createNativeQuery("INSERT INTO service_user(fullname, email, username, user_role, password) VALUES (?,?,?,?,?)")
                .setParameter(1, customerData.getFullname())
                .setParameter(2, customerData.getEmail())
                .setParameter(3, customerData.getUsername())
                .setParameter(4, "CUSTOMER")
                .setParameter(5, passwordEncoder.encode(customerData.getPassword()) )
                .executeUpdate();
    }
}