package com.ads.advertisement.dao.entity.Products;

import com.ads.advertisement.dao.entity.ImagesEntity;
import com.ads.advertisement.dao.entity.SubCategoryEntity;
import com.ads.advertisement.dao.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;
    float price;
    @Column(name = "active_status")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    ProductActiveStatus productActiveStatus = ProductActiveStatus.PENDING;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @Builder.Default
    ProductType productType = ProductType.SIMPLE;

    @Column(name = "views_count")
    int viewsCount;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sub_category_id")
    SubCategoryEntity subCategoryEntity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    UserEntity userEntity;

    @OneToMany(mappedBy = "productsEntity")
    @JsonBackReference
     List<ImagesEntity> imagesEntity;

    @Column(name = "created_at")
    @CreationTimestamp
    Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    Timestamp updatedAt;

}
