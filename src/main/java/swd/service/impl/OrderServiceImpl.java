package swd.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import swd.dataobject.OrderMaster;
import swd.dto.OrderDTO;
import swd.service.OrderService;

/**
 * Created by swd on 2018/7/28
 */
@Service
public class OrderServiceImpl implements OrderService
{
    @Override
    public OrderDTO create(OrderMaster orderMaster)
    {
        return null;
    }

    @Override
    public OrderDTO findOne(OrderMaster orderMaster)
    {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable)
    {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO)
    {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO)
    {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO)
    {
        return null;
    }
}
