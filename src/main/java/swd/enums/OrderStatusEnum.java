package swd.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum
{
    NEW(0,"新订单"),
    CANCEL(1,"取消订单"),
    FINISH(2,"完成订单");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
