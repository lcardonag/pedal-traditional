package com.example.bike_commerce.employees.repositories;

import com.example.bike_commerce.employees.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {
    Optional<Employees> findUserByUsername(String username);

}
