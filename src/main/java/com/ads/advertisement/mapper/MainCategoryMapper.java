package com.ads.advertisement.mapper;

import com.ads.advertisement.dao.entity.MainCategoryEntity;
import com.ads.advertisement.dto.MainCategoryDto;
import com.ads.advertisement.dto.requests.MainCategoryRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class MainCategoryMapper {
    public static final MainCategoryMapper INSTANCE = Mappers.getMapper(MainCategoryMapper.class);

    public abstract List<MainCategoryDto> entityToDtoList(List<MainCategoryEntity> mainCategoryEntityList);

    public abstract MainCategoryDto entityToDto(MainCategoryEntity mainCategoryEntity);

    public abstract MainCategoryEntity dtoToEntity(MainCategoryRequestDto mainCategoryRequestDto);

}