package com.example.bike_commerce.customers.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "bike_order")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private String product_id;

    @Column(name = "customer_id")
    private String customer_id;

    @Column(name = "date_created")
    private Date date_created;

    public Long getId() {
        return id;
    }

    public Date getDateCreated() {
        return date_created;
    }

    public String getCustomerId() {
        return customer_id;
    }

    public String getProductId() {
        return product_id;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setDateCreated(Date dateCreated) {
        this.date_created = dateCreated;
    }

    public void setCustomerId(String customer_id) {
        this.customer_id = customer_id;
    }

    public void setProductId(String product_id) {
        this.product_id = product_id;
    }
}