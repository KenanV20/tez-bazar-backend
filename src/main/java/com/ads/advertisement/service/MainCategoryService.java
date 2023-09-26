package com.ads.advertisement.service;

import com.ads.advertisement.dao.entity.MainCategoryEntity;
import com.ads.advertisement.dao.repository.MainCategoryRepository;
import com.ads.advertisement.dto.MainCategoryDto;
import com.ads.advertisement.dto.requests.MainCategoryRequestDto;
import com.ads.advertisement.exception.NotFoundException;
import com.ads.advertisement.mapper.MainCategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Slf4j
@Service
public class MainCategoryService {
    private final MainCategoryRepository mainCategoryRepository;

    public void addMainCategory(MainCategoryRequestDto mainCategoryRequestDto) {
        log.info("ActionLog.start main category post method");

        MainCategoryEntity entity = MainCategoryMapper.INSTANCE.dtoToEntity(mainCategoryRequestDto);
        mainCategoryRepository.save(entity);

        log.info("ActionLog.end main category post method");
    }

    public List<MainCategoryDto> getMainCategories() {
        log.info("ActionLog.start main category get method");

        List<MainCategoryEntity> mainCategoryEntityList = mainCategoryRepository.findAll();
        if (mainCategoryEntityList.isEmpty())
            throw new NotFoundException("MAIN-CATEGORİES_NOT_FOUND");

        log.info("ActionLog.end main category get method");

        return MainCategoryMapper.INSTANCE.entityToDtoList(mainCategoryEntityList);
    }

    public MainCategoryDto getMainCategoryById(Long id) {
        log.info("ActionLog.start get main category with id: {}", id);

        MainCategoryEntity mainCategoryEntity = mainCategoryRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("MAIN-CATEGORY_NOT_FOUND");
        });

        log.info("ActionLog.end get main category with id: {}", id);

        return MainCategoryMapper.INSTANCE.entityToDto(mainCategoryEntity);
    }

    public void updateMainCategory(Long id, MainCategoryRequestDto mainCategoryRequestDto) {
        log.info("ActionLog.start update main category with id: {}", id);

        MainCategoryEntity mainCategoryEntity = mainCategoryRepository.findById(id).orElseThrow(() ->
                new NotFoundException("MAIN-CATEGORY_NOT_FOUND"));
        BeanUtils.copyProperties(mainCategoryRequestDto, mainCategoryEntity, "id");
        mainCategoryRepository.save(mainCategoryEntity);

        log.info("ActionLog.end update main category with id: {}", id);
    }

    public void deleteMainCategory(Long id) {
        log.info("ActionLog.start delete main category id: {}", id);

        if (!mainCategoryRepository.existsById(id))
            throw new NotFoundException("MAIN-CATEGORY_NOT_EXİST");
        mainCategoryRepository.deleteById(id);

        log.info("ActionLog.end delete main category id: {}", id);
    }

}
