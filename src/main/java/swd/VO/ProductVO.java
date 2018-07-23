package swd.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.type.ListType;

import java.util.List;

/**
 * Created by swd on 2018/7/23
 */
@Data
public class ProductVO
{
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private String categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
