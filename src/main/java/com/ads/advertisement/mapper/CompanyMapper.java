package com.ads.advertisement.mapper;

import com.ads.advertisement.dao.entity.CompanyEntity;
import com.ads.advertisement.dto.CompanyDto;
import com.ads.advertisement.dto.requests.CompanyRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CompanyMapper {

    public static CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    public abstract CompanyDto entityToDto(CompanyEntity companyEntity);
    public abstract CompanyEntity dtoToEntity(CompanyRequestDto companyRequestDto);
}
