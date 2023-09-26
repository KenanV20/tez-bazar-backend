package com.ads.advertisement.service;

import com.ads.advertisement.dao.entity.ImagesEntity;
import com.ads.advertisement.dao.entity.MainCategoryEntity;
import com.ads.advertisement.dao.repository.ImagesRepository;
import com.ads.advertisement.dto.ImagesDto;
import com.ads.advertisement.dto.MainCategoryDto;
import com.ads.advertisement.exception.NotFoundException;
import com.ads.advertisement.mapper.ImagesMapper;
import com.ads.advertisement.mapper.MainCategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImagesService {

    private final ImagesRepository imagesRepository;

    public ImagesDto getImage(Long id) {
        log.info("ActionLog.start image get method");

        ImagesEntity imagesEntity = imagesRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Image_NOT_FOUND");
        });

        log.info("ActionLog.end image get method");

        return ImagesMapper.INSTANCE.entityToDto(imagesEntity);
    }
}
