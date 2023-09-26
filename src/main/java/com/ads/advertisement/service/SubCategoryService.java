package com.ads.advertisement.service;

import com.ads.advertisement.dao.entity.MainCategoryEntity;
import com.ads.advertisement.dao.entity.SubCategoryEntity;
import com.ads.advertisement.dao.repository.MainCategoryRepository;
import com.ads.advertisement.dao.repository.SubCategoryRepository;
import com.ads.advertisement.dto.SubCategoryDto;
import com.ads.advertisement.dto.requests.SubCategoryRequestDto;
import com.ads.advertisement.exception.NotFoundException;
import com.ads.advertisement.mapper.SubCategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final MainCategoryRepository mainCategoryRepository;

    public SubCategoryDto addSubCategory(
            SubCategoryRequestDto subCategoryRequestDto,
            Long categoriesId
    ) {
        log.info("ActionLog.start sub category post method");
        MainCategoryEntity mainCategoryEntity = mainCategoryRepository.findById(categoriesId).get();
        SubCategoryEntity subCategoryEntity = SubCategoryMapper.INSTANCE.dtoToEntity(subCategoryRequestDto);
        subCategoryEntity.setMainCategoryEntity(mainCategoryEntity);
        SubCategoryDto result = SubCategoryMapper.INSTANCE.entityToDto(subCategoryRepository.save(subCategoryEntity));
        log.info("ActionLog.end sub category post method");
        return result;
    }

    public List<SubCategoryDto> getSubCategories(Long categoriesId) {
        MainCategoryEntity mainCategoryEntity = mainCategoryRepository.findById(categoriesId).get();
        return SubCategoryMapper.INSTANCE.entityToDtoList(subCategoryRepository.findByMainCategoryEntity(mainCategoryEntity));
    }

    public SubCategoryDto updateSubCategory(SubCategoryRequestDto subCategoryRequestDto, Long categoryId, Long subCategoryId) {
        MainCategoryEntity mainCategoryEntity = mainCategoryRepository.findById(categoryId).get();
        SubCategoryEntity subCategoryEntity = subCategoryRepository.findById(subCategoryId).get();

        subCategoryEntity.setMainCategoryEntity(mainCategoryEntity);
        BeanUtils.copyProperties(subCategoryRequestDto, subCategoryEntity);
        return SubCategoryMapper.INSTANCE.entityToDto(subCategoryRepository.save(subCategoryEntity));
    }

    public void deleteSubCategory(Long subCategoryId) {
        log.info("ActionLog.start delete sub category id: {}", subCategoryId);
        subCategoryRepository.deleteById(subCategoryId);
        log.info("ActionLog.end delete sub category id: {}", subCategoryId);
    }
}
