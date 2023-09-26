package com.ads.advertisement.service;

import com.ads.advertisement.dao.entity.ImagesEntity;
import com.ads.advertisement.dao.entity.MainCategoryEntity;
import com.ads.advertisement.dao.entity.Products.ProductType;
import com.ads.advertisement.dao.entity.Products.ProductsEntity;
import com.ads.advertisement.dao.repository.ImagesRepository;
import com.ads.advertisement.dao.repository.ProductsRepository;
import com.ads.advertisement.dto.MainCategoryDto;
import com.ads.advertisement.dto.ProductsDto;
import com.ads.advertisement.dto.requests.MainCategoryRequestDto;
import com.ads.advertisement.dto.requests.ProductsRequestDto;
import com.ads.advertisement.exception.NotFoundException;
import com.ads.advertisement.mapper.MainCategoryMapper;
import com.ads.advertisement.mapper.ProductsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;

    private final ImagesRepository imagesRepository;

    public void addProducts(ProductsRequestDto productsRequestDto) {
        log.info("ActionLog.start product post method");

        ProductsEntity entity = ProductsMapper.INSTANCE.dtoToEntity(productsRequestDto);
        productsRepository.save(entity);

        List <ImagesEntity> imagesEntity = productsRequestDto.getImagesEntity();
        imagesRepository.saveAll(imagesEntity);
        log.info("ActionLog.end product post method");
    }


    public List<ProductsDto> getProducts() {
        log.info("ActionLog.start products get method");

        List<ProductsEntity> productsEntityList = productsRepository.findAll();
        if (productsEntityList.isEmpty())
            throw new NotFoundException("Products_NOT_FOUND");

        log.info("ActionLog.end products get method");

        return ProductsMapper.INSTANCE.entityToDtoList(productsEntityList);
    }
    public ProductsDto getProductById(Long id) {
        log.info("ActionLog.start get product with id: {}", id);

        ProductsEntity productsEntity = productsRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("PRODUCT_NOT_FOUND");
        });

        productsEntity.setViewsCount(productsEntity.getViewsCount() + 1);
        productsRepository.save(productsEntity);

        log.info("ActionLog.end get product with id: {}", id);

        return ProductsMapper.INSTANCE.entityToDto(productsEntity);
    }
    public void updateProduct(Long id, ProductsRequestDto productsRequestDto) {
        log.info("ActionLog.start update product with id: {}", id);

        ProductsEntity productsEntity = productsRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Product_NOT_FOUND"));
        BeanUtils.copyProperties(productsRequestDto, productsEntity, "id");
        productsRepository.save(productsEntity);

        log.info("ActionLog.end update main category with id: {}", id);
    }
    public void deleteProduct(Long id) {
        log.info("ActionLog.start delete product id: {}", id);

        if (!productsRepository.existsById(id))
            throw new NotFoundException("PRODUCT_NOT_EXİST");
        productsRepository.deleteById(id);

        log.info("ActionLog.end delete product id: {}", id);
    }
        public Page<ProductsDto> getProductsOrderByCreatedAt(int page,int size) {
        log.info("ActionLog.start products get method order by created at");


        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
            Page<ProductsEntity> simpleProductsPage = productsRepository.findByProductType(ProductType.SIMPLE,pageable);

            List<ProductsDto> simpleProductsList = ProductsMapper.INSTANCE.entityToDtoList(simpleProductsPage.getContent());

        log.info("ActionLog.end products get method order by created at");

        return new PageImpl<>(simpleProductsList, pageable, simpleProductsPage.getTotalElements());
    }

        public Page<ProductsDto> getVIPProducts(int pageNumber, int pageSize) {

            log.info("ActionLog.start products get method order by VIP status and created at");

            Pageable pageable = PageRequest.of(pageNumber, pageSize,Sort.by(Sort.Direction.DESC, "createdAt"));
            Page<ProductsEntity> vipProductsPage = productsRepository.findByProductType(ProductType.VIP,pageable);

            List<ProductsDto> vipProductsDtoList = ProductsMapper.INSTANCE.entityToDtoList(vipProductsPage.getContent());

            log.info("ActionLog.end products get method order by VIP status and created at");

            return new PageImpl<>(vipProductsDtoList, pageable, vipProductsPage.getTotalElements());
        }


}






