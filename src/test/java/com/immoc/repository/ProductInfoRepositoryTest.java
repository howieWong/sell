package com.immoc.repository;

import com.immoc.dataObject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

        @Autowired
        private ProductInfoRepository repository;

        @Test
        public void testSave() {
                String id = UUID.randomUUID().toString().replace("-", "");
                System.out.println(id);
                ProductInfo info = new ProductInfo();
        }

        @Test
        public void findByProductStatus() {
                List<ProductInfo> productInfos = repository.findByProductStatus(1);
                productInfos.forEach(System.out::println);
        }
}