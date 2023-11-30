package com.example.trangbanhangonline.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum {

    ChoXacNhan(1) ,DaXacNhan(2), HuyDatHang(3);

    int numberStatus;


    public static OrderStatusEnum numberToEnum(Integer numberStatus){
        if(numberStatus == null) return null;
        for(OrderStatusEnum  orderStatusEnum : OrderStatusEnum.values()){
            if(orderStatusEnum.getNumberStatus() == numberStatus) return orderStatusEnum;
        }
        return null;
    }
}
