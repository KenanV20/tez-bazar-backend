package com.ads.advertisement.dao.repository;

import com.ads.advertisement.dao.entity.MainCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainCategoryRepository extends JpaRepository<MainCategoryEntity,Long> {
    void deleteById(Long id);
}
