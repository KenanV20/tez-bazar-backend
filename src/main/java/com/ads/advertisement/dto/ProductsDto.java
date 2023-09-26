package com.ads.advertisement.dto;

import com.ads.advertisement.dao.entity.Products.ProductType;
import com.ads.advertisement.dao.entity.SubCategoryEntity;
import com.ads.advertisement.dao.entity.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductsDto {
    Long id;
    String name;
    String description;
    ProductType productType;
    float price;
    int viewsCount;
    LocalDate createdAt;

    Long subCategoryId;

    Long userId;

    List<Long> imagesId;
}
