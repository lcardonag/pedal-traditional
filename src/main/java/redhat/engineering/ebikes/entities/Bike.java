package redhat.engineering.ebikes.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "bikes")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Bike's name cannot be empty.")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Bike's model cannot be empty.")
    @Column(name = "model")
    private String model;

    @Column(name = "date_created")
    private Date dateCreated;

    @NotNull(message = "Bike's price cannot be empty.")
    @Column(name = "price")
    private Integer price;

    @Column(name = "image")
    private Byte image;

    @NotNull(message = "Bike's warranty status cannot be empty.")
    @Column(name = "warranty_status")
    private String warrantyStatus;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public Integer getPrice() {
        return price;
    }

    public String getWarrantyStatus() {
        return warrantyStatus;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Byte getImage() {
        return image;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setWarrantyStatus(String warrantyStatus) {
        this.warrantyStatus = warrantyStatus;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setImage(Byte image) {
        this.image = image;
    }
}
