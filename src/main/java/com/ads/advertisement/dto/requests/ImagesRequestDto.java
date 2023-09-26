package com.ads.advertisement.dto.requests;

import com.ads.advertisement.dao.entity.Products.ProductsEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class ImagesRequestDto {
    String  url;
    ProductsEntity productsEntity;
}
