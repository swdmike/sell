package swd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swd.dataobject.OrderDetail;
import java.util.List;

/**
 * Created by swd on 2018/7/24
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>
{
    List<OrderDetail> findByOrderId(String orderId);
}
