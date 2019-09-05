package com.immoc.service.impl;


import com.immoc.dataObject.ProductInfo;
import com.immoc.enums.ProductStatusEnum;
import com.immoc.repository.ProductInfoRepository;
import com.immoc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {

        @Autowired
        ProductInfoRepository repository;

        @Override
        public ProductInfo findOne(String id) {
                return repository.findOne(id);
        }

        @Override
        public List<ProductInfo> findUpAll() {
                return repository.findByProductStatus(ProductStatusEnum.Up.getCode());
        }

        @Override
        public Page<ProductInfo> findAll(Pageable page) {
                return repository.findAll(page);
        }

        @Override
        public ProductInfo save(ProductInfo productInfo) {
                return repository.save(productInfo);
        }

}
