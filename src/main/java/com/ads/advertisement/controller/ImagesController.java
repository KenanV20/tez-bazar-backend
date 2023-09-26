package com.ads.advertisement.controller;

import com.ads.advertisement.dto.ImagesDto;
import com.ads.advertisement.dto.MainCategoryDto;
import com.ads.advertisement.service.ImagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/images")
public class ImagesController {

    private  final ImagesService imagesService;

    @GetMapping("/{id}")
    public ImagesDto getImageById(@PathVariable Long id ){
        return imagesService.getImage(id);
    }
}
