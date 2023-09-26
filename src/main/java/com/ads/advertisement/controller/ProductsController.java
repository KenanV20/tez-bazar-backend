package com.ads.advertisement.controller;

import com.ads.advertisement.dto.MainCategoryDto;
import com.ads.advertisement.dto.ProductsDto;
import com.ads.advertisement.dto.SimpleMessageDto;
import com.ads.advertisement.dto.requests.MainCategoryRequestDto;
import com.ads.advertisement.dto.requests.ProductsRequestDto;
import com.ads.advertisement.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/products")
public class ProductsController {
    private final ProductsService productsService;


    @PostMapping
    public SimpleMessageDto addProducts(@Valid @RequestBody ProductsRequestDto productsRequestDto) {
        productsService.addProducts(productsRequestDto);
        return new SimpleMessageDto("Product category was added");
    }

    @GetMapping
    public List<ProductsDto> getProducts() {
        return productsService.getProducts();
    }
    @GetMapping("/{id}")
    public ProductsDto getProductById(@PathVariable Long id ){
        return productsService.getProductById(id);
    }
    @GetMapping("/orderByCreatedAt")
    public Page<ProductsDto> getProductsOrderByCreatedAt(int page, int size) {
        return productsService.getProductsOrderByCreatedAt(page, size);
    }
    @DeleteMapping("/{id}")
    public SimpleMessageDto deleteProduct(@PathVariable Long id){
        productsService.deleteProduct(id);
        return new SimpleMessageDto("Product was deleted");
    }
    @PutMapping("/{id}")
    public SimpleMessageDto updateProduct(@PathVariable Long id,@RequestBody ProductsRequestDto productsRequestDto){
        productsService.updateProduct(id,productsRequestDto);
        return new SimpleMessageDto("Product was updated");
    }
    @GetMapping("/VIPProducts")
    public Page<ProductsDto> getVIPProducts(int pageNumber, int pageSize) {
        return productsService.getVIPProducts(pageNumber, pageSize);


    }
}
