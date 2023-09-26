package com.ads.advertisement.dto.requests;

import com.ads.advertisement.annotations.WordCount;
import com.ads.advertisement.dao.entity.ImagesEntity;
import com.ads.advertisement.dao.entity.SubCategoryEntity;
import com.ads.advertisement.dao.entity.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class ProductsRequestDto {

    @NotBlank(message = "Name may not be null or empty")
    @Size(min = 2, message = "Name must must contain at least 2 characters")
    String name;

    @WordCount
    String description;

    int price;

    SubCategoryEntity subCategoryEntity;

    UserEntity userEntity;
    List<ImagesEntity> imagesEntity;
}
