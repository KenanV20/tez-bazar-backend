package com.ads.advertisement.controller;

import com.ads.advertisement.dto.MainCategoryDto;
import com.ads.advertisement.dto.SimpleMessageDto;
import com.ads.advertisement.dto.requests.MainCategoryRequestDto;
import com.ads.advertisement.service.MainCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/categories")
public class MainCategoryController {
    private final MainCategoryService mainCategoryService;

    @PostMapping
    public SimpleMessageDto addMainCategory(@Valid @RequestBody MainCategoryRequestDto mainCategoryRequestDto) {
        mainCategoryService.addMainCategory(mainCategoryRequestDto);
        return new SimpleMessageDto("Main category was added");
    }

    @GetMapping
    public List<MainCategoryDto> getMainCategories() {
        return mainCategoryService.getMainCategories();
    }

    @GetMapping("/{id}")
    public MainCategoryDto getMainCategoryById(@PathVariable Long id ){
        return mainCategoryService.getMainCategoryById(id);
    }
    @PutMapping("/{id}")
    public SimpleMessageDto updateMainCategory(@PathVariable Long id,@RequestBody MainCategoryRequestDto mainCategoryRequestDto){
       mainCategoryService.updateMainCategory(id,mainCategoryRequestDto);
        return new SimpleMessageDto("Main category was updated");
    }

    @DeleteMapping("/{id}")
    public SimpleMessageDto deleteMainCategory(@PathVariable Long id){
           mainCategoryService.deleteMainCategory(id);
         return new SimpleMessageDto("Main category was deleted");
    }
}
