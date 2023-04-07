package io.iam149cm.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor // default constructor
@AllArgsConstructor // a parameterized constructor

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
    @CreationTimestamp // get current time from the JVM - Hibernate annotation
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;


}
