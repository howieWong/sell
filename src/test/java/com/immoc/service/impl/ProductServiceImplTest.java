package com.immoc.service.impl;

import com.immoc.dataObject.ProductInfo;
import com.immoc.enums.ProductStatusEnum;
import com.immoc.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

        @Autowired
        private ProductServiceImpl impl;

        @Test
        public void findOne() {
                ProductInfo info = impl.findOne("12345");
                System.out.println(info);
        }

        @Test
        public void findUpAll() {
                List<ProductInfo> list = impl.findUpAll();
                list.forEach(System.out::println);
        }

        @Test
        public void findAll() {
                PageRequest request = new PageRequest(1, 1);
                Page<ProductInfo> infos = impl.findAll(request);
                //System.out.println(infos.getContent());
                infos.getContent().forEach(System.out::println);

        }

        @Test
        public void save() {

                ProductInfo info = new ProductInfo();
                info.setProductId("22222");
                info.setProductName("喜茶");
                info.setProductIcon("http://xxx.img");
                info.setProductPrice(new BigDecimal(35));
                info.setProductStatus(ProductStatusEnum.Up.getCode());
                info.setCategoryType(3);
                info.setProductStock(20);
                impl.save(info);

        }
}