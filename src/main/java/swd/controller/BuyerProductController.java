package swd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swd.VO.ProductInfoVO;
import swd.VO.ProductVO;
import swd.VO.ResultVO;
import swd.dataobject.ProductCategory;
import swd.dataobject.ProductInfo;
import swd.service.CategoryService;
import swd.service.ProductService;
import swd.service.impl.ProductServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by swd on 2018/7/23
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController
{
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list()
    {
        //查询所有上架商品
        List<ProductInfo> upAll = productService.findUpAll();
        List<Integer> categoryList = new ArrayList<>();
//        for(ProductInfo productInfo: upAll)
//        {
//            categoryList.add(productInfo.getCategoryType());
//        }
        categoryList = upAll.stream().map(i -> i.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> catagories = categoryService.findByCategoryTypeIn(categoryList);
        for(ProductCategory productCategory:catagories)
        {
ProductVO productVO = new ProductVO();
productVO.setCategoryName(productCategory.getCategoryName());
productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setProductInfoVOList();
for(ProductInfo productInfo:upAll){
    if(productInfo.getCategoryType().equals(productCategory.getCategoryType()))
    {

    }
}

        }

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("success");

        ProductInfoVO productInfoVO = new ProductInfoVO();
        ProductVO productVO = new ProductVO();
        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));

        resultVO.setData(Arrays.asList(productVO));
        return resultVO;
    }
}
