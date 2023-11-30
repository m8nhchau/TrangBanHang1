package com.example.trangbanhangonline.conveter;

import com.example.trangbanhangonline.enums.OrderStatusEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class OrderStatusConveter implements AttributeConverter<OrderStatusEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrderStatusEnum orderStatusEnum) {
        return orderStatusEnum.getNumberStatus();
    }

    @Override
    public OrderStatusEnum convertToEntityAttribute(Integer integer) {
        return OrderStatusEnum.numberToEnum(integer);
    }
}
