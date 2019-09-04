package com.immoc.service;

import com.immoc.dataObject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
        ProductCategory findOne(Integer id);

        List<ProductCategory> findAll();

        List<ProductCategory> findByCategoryTypeIn(List<Integer> list);

        ProductCategory save(ProductCategory category);
}
