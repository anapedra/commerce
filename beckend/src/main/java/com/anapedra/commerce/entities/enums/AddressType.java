package com.anapedra.commerce.entities.enums;

public enum AddressType {

    /*
    Attention: When inserting another enumerator, sequence the integers
    in the proposed order to avoid a possible collapse of subsequent codes.
     */

    DELIVERY_ADDRESS(1),
    HOME_ADDRESS(2),
    BELLING_ADDRESS(3),
    SHIPPING_ADDRESS(4);

    private int code;
    private AddressType(int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }

    public static AddressType valueOf(int code){
        for(AddressType value : AddressType.values()){
           if (value.getCode()==code){
               return value;
           }
        }
        throw new IllegalArgumentException("Invalid code!");
    }


}
