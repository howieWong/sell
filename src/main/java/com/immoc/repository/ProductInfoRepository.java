package com.immoc.repository;

import com.immoc.dataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {//<l类名，主键>

        List<ProductInfo> findByProductStatus(Integer productStatus);
}
