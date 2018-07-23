package swd.service;

import swd.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService
{
    ProductCategory findOne(Integer id);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> types);
    ProductCategory save(ProductCategory productCategory);
}
