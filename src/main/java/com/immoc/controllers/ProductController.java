package com.immoc.controllers;

import com.immoc.dataObject.ProductCategory;
import com.immoc.dataObject.ProductInfo;
import com.immoc.enums.ProductStatusEnum;
import com.immoc.service.CategoryService;
import com.immoc.service.ProductService;
import com.immoc.vo.ProductInfoVO;
import com.immoc.vo.ProductVO;
import com.immoc.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class ProductController {

        @Autowired
        ProductService productService;

        @Autowired
        CategoryService categoryService;

        @RequestMapping("/list")
        public ResultVO getList() {
/*                PageRequest pageRequest = new PageRequest(0,3);
                Page<ProductInfo> pages = productService.findAll(pageRequest);
                List<ProductInfo> infos = pages.getContent();*/

                List<ProductInfo> infos = productService.findUpAll();//1query all up products
                //query all types
                List<Integer> clists = infos.stream()
                        .map(e -> e.getCategoryType())
                        .collect(Collectors.toList());

                //add to restVO object
                List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(clists);
                List<ProductVO> listPoVo = new ArrayList<>();
                for (ProductCategory productCategory : productCategories) {
                        ProductVO pvo = new ProductVO();
                        pvo.setCategoryName(productCategory.getCategoryName());
                        pvo.setCategoryType(productCategory.getCategoryType());
                        List<ProductInfoVO> list = new ArrayList<>();
                        for (ProductInfo info : infos) {
                                if (info.getCategoryType().equals(productCategory.getCategoryType())) {
                                        ProductInfoVO pivo = new ProductInfoVO();
                                        BeanUtils.copyProperties(info, pivo);
                                        list.add(pivo);
                                }
                        }
                        pvo.setList(list);
                        listPoVo.add(pvo);
                }

                ResultVO vo = new ResultVO();

                vo.setCode(0);
                vo.setMsg("成功");
                vo.setData(listPoVo);


                return vo;

        }
}
