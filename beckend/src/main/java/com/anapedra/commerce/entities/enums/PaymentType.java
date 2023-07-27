package com.anapedra.commerce.entities.enums;

public enum PaymentType {
    /*
      Attention: When inserting another enumerator, sequence the integers
      in the proposed order to avoid a possible collapse of subsequent codes.
         */

    PIX(1),
    DEBIT_CARD(2),
    CREDIT_CARD1x(3),
    CREDIT_CARD2x(4),
    CREDIT_CARD3x(5);





    private int code;

    private PaymentType(int code){
        this.code=code;
    }

    public int getCode(){
        return code;
    }

    public static PaymentType valueOf(int code){
        for(PaymentType value : PaymentType.values() ) {
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code!");
    }


}
