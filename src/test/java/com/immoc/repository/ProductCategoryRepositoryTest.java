package com.immoc.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
public class ProductCategoryRepositoryTest {

        @Autowired
        private ProductCategoryRepository repository;

        @Test
        public void select() {
                ProductCategory category = repository.findOne(1);
                Assert.assertNotNull(category);
                List<ProductCategory> list = repository.findByCategoryTypeIn(Arrays.asList(1, 3, 5));
                list.forEach(System.out::println);
                Assert.assertNotEquals(0, list.size());
        }

        @Test
        @Transactional//只做测试使用，执行完立刻回滚，不会对数据库进行操作
        public void insert() {
                ProductCategory category = new ProductCategory();
                category.setCategoryName("男生最爱");
                category.setCategoryId(1);

                category.setCategoryType(3);
                repository.save(category);
/*                ProductCategory category = repository.findOne(1);
                category.setCategoryType(1);
                repository.save(category);*/
        }


}