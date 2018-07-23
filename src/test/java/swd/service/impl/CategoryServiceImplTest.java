package swd.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import swd.dataobject.ProductCategory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest
{
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne()
    {
        ProductCategory result = categoryService.findOne(1);
        Assert.assertEquals(1, (long)result.getCategoryId());
    }

    @Test
    public void findAll()
    {
        List<ProductCategory> all = categoryService.findAll();
        Assert.assertNotEquals(0, all.size());
    }

    @Test
    public void findByCategoryTypeIn()
    {
        List<Integer> types = Arrays.asList(1,2,3,4);
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(types);
        Assert.assertNotEquals(0, categoryList.size());
    }

    @Test
    public void save()
    {
        ProductCategory productCategory =new ProductCategory();
        productCategory.setCategoryType(3);
        productCategory.setCategoryName("热销榜");
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertEquals(2, result.getCategoryType().longValue());

    }
}