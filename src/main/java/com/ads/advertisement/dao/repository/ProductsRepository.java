package com.ads.advertisement.dao.repository;

import com.ads.advertisement.dao.entity.Products.ProductType;
import com.ads.advertisement.dao.entity.Products.ProductsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductsRepository extends JpaRepository<ProductsEntity,Long> {
    Page<ProductsEntity> findByProductType(ProductType productType, Pageable pageable);
}
