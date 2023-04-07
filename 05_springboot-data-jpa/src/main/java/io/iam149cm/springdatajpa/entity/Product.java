package io.iam149cm.springdatajpa.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products",
        schema = "ecommerce",
        uniqueConstraints = {
        @UniqueConstraint(name = "sku_unique", columnNames = "stock_keeping_unit"),
//        @UniqueConstraint(name = "name_unique", columnNames = "name")
        }
)
public class Product {

    // GenerationType.Auto: Hibernate will choose the best strategy for the underlying database.
    // GenerationType.IDENTITY: The persistence provider must assign primary keys for the entity using a database identity column.
    // GenerationType.SEQUENCE: The persistence provider must assign primary keys for the entity using a database sequence. - if the application is huge, sequence is recommended
    // GenerationType.TABLE: The persistence provider must assign primary keys for the entity using an underlying database table to ensure uniqueness. - rarely used

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name = "product_generator",
    sequenceName = "product_sequence",
    allocationSize = 1)
    private long id;
    @Column(name = "stock_keeping_unit", nullable = false) // customize column name
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
