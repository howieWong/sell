package com.immoc.service.impl;

import com.immoc.dataObject.ProductCategory;
import com.immoc.repository.ProductCategoryRepository;
import com.immoc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

        @Autowired
        private ProductCategoryRepository repository;

        @Override
        public ProductCategory findOne(Integer id) {
                return repository.findOne(id);
        }

        @Override
        public List<ProductCategory> findAll() {
                return repository.findAll();
        }

        @Override
        public List<ProductCategory> findByCategoryTypeIn(List<Integer> list) {
                return repository.findByCategoryTypeIn(list);
        }

        @Override
        public ProductCategory save(ProductCategory category) {
                return repository.save(category);
        }
}
