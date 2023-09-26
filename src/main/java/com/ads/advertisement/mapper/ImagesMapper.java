package com.ads.advertisement.mapper;

import com.ads.advertisement.dao.entity.ImagesEntity;
import com.ads.advertisement.dto.ImagesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public abstract class ImagesMapper {
    public static final ImagesMapper INSTANCE = Mappers.getMapper(ImagesMapper.class);

    public abstract ImagesDto entityToDto(ImagesEntity imagesEntity);

}
