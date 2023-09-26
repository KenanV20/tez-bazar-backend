package com.ads.advertisement.mapper;

import com.ads.advertisement.dao.entity.SubCategoryEntity;
import com.ads.advertisement.dto.SubCategoryDto;
import com.ads.advertisement.dto.requests.SubCategoryRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class SubCategoryMapper {

    public static final SubCategoryMapper INSTANCE = Mappers.getMapper(SubCategoryMapper.class);

    public abstract SubCategoryEntity dtoToEntity(SubCategoryRequestDto subCategoryRequestDto);

    public abstract SubCategoryDto entityToDto(SubCategoryEntity subCategoryEntity);

    public abstract List<SubCategoryDto> entityToDtoList(List<SubCategoryEntity> subCategoryEntityList);

}
