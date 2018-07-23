package swd.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import swd.enums.ProductStatusEnum;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by swd on 2018/7/23
 */
@Data
public class ProductInfoVO
{
    @JsonProperty("id")
    private String productId;

    /** 名字. */
    @JsonProperty("name")
    private String productName;

    /** 单价. */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /** 描述. */
    @JsonProperty("description")
    private String productDescription;

    /** 小图. */
    @JsonProperty("icon")
    private String productIcon;
}
