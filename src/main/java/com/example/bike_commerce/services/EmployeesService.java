package com.example.bike_commerce.services;

import com.example.bike_commerce.employees.entities.Employees;
import com.example.bike_commerce.employees.repositories.EmployeeRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;
import jakarta.transaction.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Configurable
public class EmployeesService {
    @Autowired
    EmployeeRepository employeeRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private UUID generateUUID;

    @PersistenceContext(unitName = "employeesEntityManagerFactory")
//    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Employees> retrieveEmployee(Long userId) {
        return employeeRepository.findById(userId);
    }

    public List<Employees> retrieveAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    public void createEmployee(Employees employeeData) {
//        employeeRepository.save(employeeData);

        employeeRepository.save(employeeData);

//        Employees employeeObj = new Employees();
//
//        employeeObj.

//        entityManager.createNativeQuery("INSERT INTO employees(fullname, email, username, user_role, password) VALUES (?,?,?,?,?)")
//                .setParameter(1, employeeData.getFullname())
//                .setParameter(2, employeeData.getEmail())
//                .setParameter(3, employeeData.getUsername())
//                .setParameter(4, employeeData.getUser_role())
////                .setParameter(4, passwordEncoder.encode(employeeData.getPassword()) )
//                .setParameter(5, employeeData.getPassword())
//                .executeUpdate();
    }
}