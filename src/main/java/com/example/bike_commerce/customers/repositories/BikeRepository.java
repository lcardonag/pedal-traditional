package com.example.bike_commerce.customers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bike_commerce.customers.entities.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> { }

