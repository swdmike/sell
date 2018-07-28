package swd.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import swd.dataobject.OrderMaster;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest
{
    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void findByBuyerOpenid()
    {
        PageRequest request = new PageRequest(0,2);
        Page<OrderMaster> page = repository.findByBuyerOpenid("110110", request);
        Assert.assertNotEquals(0, page.getTotalElements());
    }

    @Test
    public void saveTest()
    {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123482");
        orderMaster.setBuyerName("三姑");
        orderMaster.setBuyerPhone("18356780000");
        orderMaster.setBuyerAddress("古荡");
        orderMaster.setBuyerOpenid("112112");
        orderMaster.setOrderAmount(new BigDecimal(0.18));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
}