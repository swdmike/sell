package swd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swd.dataobject.ProductCategory;
import swd.repository.ProductCategoryRepository;
import swd.service.CategoryService;

import java.util.List;

/**
 * Created by swd on 2018/7/23
 */
@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer id)
    {
        return repository.findOne(id);
    }

    @Override
    public List<ProductCategory> findAll()
    {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> types)
    {
        return repository.findByCategoryTypeIn(types);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory)
    {
        return repository.save(productCategory);
    }
}
