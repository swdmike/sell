package swd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import swd.dataobject.OrderMaster;


public interface OrderMasterRepository extends JpaRepository<OrderMaster, String>
{
    Page<OrderMaster> findByBuyerOpenid(String openid, Pageable pageable);
}
