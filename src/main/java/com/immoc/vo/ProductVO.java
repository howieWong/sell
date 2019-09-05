package com.immoc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.immoc.dataObject.ProductInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductVO {

        @JsonProperty("name")
        private String categoryName;
        @JsonProperty("type")
        private Integer categoryType;
        @JsonProperty("foods")
        private List<ProductInfoVO> list;


}
