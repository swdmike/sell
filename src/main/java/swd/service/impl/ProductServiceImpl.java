package swd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import swd.dataobject.ProductInfo;
import swd.dto.CartDTO;
import swd.enums.ProductStatusEnum;
import swd.enums.ResultEnum;
import swd.exception.SellException;
import swd.repository.ProductInfoRepository;
import swd.service.ProductService;

import java.nio.channels.SeekableByteChannel;
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

    @Override
    public void increaseStock(List<CartDTO> cartDTOList)
    {for (CartDTO cartDTO: cartDTOList)
    {
        ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
        if (productInfo == null)
        {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
        productInfo.setProductStock(result);

        repository.save(productInfo);
    }

    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOList)
    {
        for (CartDTO cartDTO : cartDTOList)
        {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null)
            {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0)
            {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
