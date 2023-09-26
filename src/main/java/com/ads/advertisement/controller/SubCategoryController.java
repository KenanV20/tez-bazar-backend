package com.ads.advertisement.controller;

import com.ads.advertisement.annotations.ExistsInDatabase;
import com.ads.advertisement.dto.SimpleMessageDto;
import com.ads.advertisement.dto.SubCategoryDto;
import com.ads.advertisement.dto.requests.SubCategoryRequestDto;
import com.ads.advertisement.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/categories/{categoryId}/sub-categories")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;




    @PostMapping
    public SubCategoryDto addSubCategory(
            @RequestBody SubCategoryRequestDto subCategoryRequestDto,
            @PathVariable("categoryId")
            @ExistsInDatabase(table = "main_categories", column = "id",message = "This main category not found")
            Long categoryId
    ) {
        return this.subCategoryService.addSubCategory(subCategoryRequestDto, categoryId);
    }
    @GetMapping
    public List<SubCategoryDto> getSubCategories(
            @PathVariable("categoryId")
            @ExistsInDatabase(table = "main_categories", column = "id",message = "This main category not found")
            Long categoryId
    ) {
        return this.subCategoryService.getSubCategories(categoryId);
    }
    @PutMapping("/{id}")
    public SubCategoryDto updateSubCategory(
            @RequestBody SubCategoryRequestDto subCategoryRequestDto,
            @PathVariable("categoryId") @ExistsInDatabase(table = "main_categories", column = "id",message = "This main category not found")
            Long categoryId,
            @PathVariable("id") @ExistsInDatabase(table = "sub_categories", column = "id",message = "This sub category not found")
            Long subCategoryId
    ) {
        return subCategoryService.updateSubCategory(subCategoryRequestDto, categoryId,subCategoryId);
    }
    @DeleteMapping("/{id}")
    public SimpleMessageDto deleteSubCategory(
            @PathVariable("id")
            @ExistsInDatabase(table = "sub_categories", column = "id",message = "This sub category not found")
            Long subCategoryId
    ) {
        this.subCategoryService.deleteSubCategory(subCategoryId);
        return new SimpleMessageDto("Sub category was deleted");
    }
}
