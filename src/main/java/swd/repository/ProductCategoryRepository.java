package swd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swd.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>
{
    List<ProductCategory> findByCategoryTypeIn(List<Integer> typeList);
}
