package com.ads.advertisement.dao.entity;

import com.ads.advertisement.dao.entity.Products.ProductsEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImagesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String url;
    int sorting;

    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name="product_id")
    private ProductsEntity productsEntity;

    @UpdateTimestamp
    private Timestamp updatedAt;
}
