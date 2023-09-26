package com.ads.advertisement.mapper;

import com.ads.advertisement.dao.entity.ImagesEntity;
import com.ads.advertisement.dao.entity.Products.ProductsEntity;
import com.ads.advertisement.dto.ProductsDto;
import com.ads.advertisement.dto.requests.ProductsRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


@Mapper
public abstract class ProductsMapper {
    public static final ProductsMapper INSTANCE = Mappers.getMapper(ProductsMapper.class);

    public abstract List<ProductsDto> entityToDtoList(List<ProductsEntity> productsEntities);

    @Mapping(target = "subCategoryId", source = "subCategoryEntity.id")
    @Mapping(target = "userId", source = "userEntity.id")
    @Mapping(target = "imagesId", source = "imagesEntity", qualifiedByName = "getImagesIds")
    public abstract ProductsDto entityToDto(ProductsEntity productsEntity);

    public abstract ProductsEntity dtoToEntity(ProductsRequestDto productsRequestDto);

    protected List<Long> getImagesIds(List<ImagesEntity> imagesEntities) {
        List<Long> ids = new ArrayList<>();
        for (ImagesEntity e:imagesEntities) {
            ids.add(e.getId());
        }
        return ids;
    }

}