package com.immoc.repository;

import com.immoc.dataObject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

        List<ProductCategory> findByCategoryTypeIn(List<Integer> list);

}
