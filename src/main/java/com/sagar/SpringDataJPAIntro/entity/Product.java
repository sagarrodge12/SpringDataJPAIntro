package com.sagar.SpringDataJPAIntro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generated"
    )
    @SequenceGenerator(
            name = "product_generated",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private long id;
    @Column(name = "stock_keeping_unit", nullable = false, unique = true)
    private String stockKeepingUnit;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;

    /* @CreationTimestamp annotation will automatically get current time from JVM and assign to this field and
        this annotation provided by hibernate, we don't need to add the value manually*/
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;


    /* Since we have added Lombok library we don't need to write getter and setter it is provided in the lombok*/
}
