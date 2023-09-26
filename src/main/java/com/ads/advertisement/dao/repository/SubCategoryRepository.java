package com.ads.advertisement.dao.repository;

import com.ads.advertisement.dao.entity.MainCategoryEntity;
import com.ads.advertisement.dao.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity,Long> {

    List<SubCategoryEntity> findByMainCategoryEntity(MainCategoryEntity mainCategoryEntity);
}
