package swd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swd.dataobject.ProductInfo;

import java.util.List;

/**
 * Created by swd on 2018/7/23
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>
{
    List<ProductInfo> findByProductStatus(Integer status);
}
