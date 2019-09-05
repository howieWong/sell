package com.immoc.service;

import com.immoc.dataObject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.PriorityQueue;

public interface ProductService {

        ProductInfo findOne(String id);

        List<ProductInfo> findUpAll();

        public Page<ProductInfo> findAll(Pageable page);

        ProductInfo save(ProductInfo productInfo);

        //increase stock

        //decrease stock


}
