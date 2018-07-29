package swd.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import swd.dataobject.OrderDetail;
import swd.dto.OrderDTO;
import swd.enums.OrderStatusEnum;
import swd.enums.PayStatusEnum;
import swd.exception.SellException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest
{
    @Autowired
    private OrderServiceImpl orderService;
    private final String BUYER_OPENID = "1101110";
    private final String ORDER_ID = "1532833633349987304";

    @Test
    @Transactional
    public void create()
    {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("廖师兄");
        orderDTO.setBuyerAddress("幕课网");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123568");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);

    }

    @Test
    public void findOne()
    {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("result={}",result);
        Assert.assertEquals(ORDER_ID, result.getOrderId());
    }

    @Test
    public void findList()
    {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID,pageRequest);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel()
    {
        OrderDTO result = orderService.findOne(ORDER_ID);
        OrderDTO cancel = orderService.cancel(result);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),
                result.getOrderStatus());
    }

    @Test
    @Transactional
    public void finish()
    {
        OrderDTO result = orderService.findOne(ORDER_ID);
        OrderDTO finish = orderService.finish(result);
        Assert.assertEquals(OrderStatusEnum.FINISH.getCode(),
                finish.getOrderStatus());
    }

    @Test
    public void paid()
    {
        OrderDTO result = orderService.findOne(ORDER_ID);
        OrderDTO paid = orderService.paid(result);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),
                paid.getPayStatus());
    }

    @Test
    public void findList1()
    {
    }
}