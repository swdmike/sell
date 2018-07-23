package swd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import swd.dataobject.ProductInfo;
import swd.enums.ProductStatusEnum;
import swd.repository.ProductInfoRepository;
import swd.service.ProductService;

import java.util.List;

/**
 * Created by swd on 2018/7/23
 */
@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String id)
    {
        return repository.findOne(id);
    }

    @Override
    public List<ProductInfo> findUpAll()
    {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable)
    {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo)
    {
        return repository.save(productInfo);
    }
}
