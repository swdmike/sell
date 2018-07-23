package swd.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import swd.dataobject.ProductInfo;

import java.util.List;

public interface ProductService
{
    ProductInfo findOne(String id);
    List<ProductInfo> findUpAll();
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);

}
