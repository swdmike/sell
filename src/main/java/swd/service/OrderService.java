package swd.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import swd.dataobject.OrderMaster;
import swd.dto.OrderDTO;

/**
 * Created by swd on 2018/7/28
 */
public interface OrderService
{
    OrderDTO create(OrderMaster orderMaster);
    OrderDTO findOne(OrderMaster orderMaster);
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    OrderDTO cancel(OrderDTO orderDTO);
    OrderDTO finish(OrderDTO orderDTO);
    OrderDTO paid(OrderDTO orderDTO);
}
