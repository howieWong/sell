package com.immoc.service.impl;

import com.immoc.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

        @Autowired
        CategoryServiceImpl service;

        @Test
        public void findOne() {
                ProductCategory category = service.findOne(1);
                Assert.assertNotNull(category);
        }

        @Test
        public void findAll() {
                List<ProductCategory> list = service.findAll();
                list.forEach(System.out::println);
        }

        @Test
        public void findByCategoryTypeIn() {
                List<ProductCategory> list = service.findByCategoryTypeIn(Arrays.asList(1, 3));
                list.forEach(System.out::println);
        }

        @Test
        @Transactional
        public void save() {
                ProductCategory category = new ProductCategory();
                category.setCategoryType(5);
                category.setCategoryName("玄幻");
                service.save(category);
        }
}