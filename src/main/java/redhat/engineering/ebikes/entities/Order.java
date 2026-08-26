package redhat.engineering.ebikes.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "bike_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "date_created")
    private Date dateCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Service_User customer;

    public Long getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getProductId() {
        return productId;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Service_User getCustomer() {
        return customer;
    }

    public void setCustomer(Service_User customer) {
        this.customer = customer;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
