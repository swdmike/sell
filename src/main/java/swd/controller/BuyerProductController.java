package swd.controller;

import org.springframework.beans.BeanUtils;
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
import swd.utils.ResultVOUtil;

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
        categoryList = upAll.stream().map(i -> i.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(categoryList);

        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory:categories)
        {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : upAll)
            {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType()))
                {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
