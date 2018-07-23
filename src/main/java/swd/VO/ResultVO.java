package swd.VO;

import lombok.Data;

/**
 * Created by swd on 2018/7/23
 */
@Data
public class ResultVO<T>
{
    private Integer code;
    private String message;
    private T data;
}
