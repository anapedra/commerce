package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.DiscountOnOrder;

import java.io.Serializable;

public class DiscountOnOrderDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private Double discount;

    public DiscountOnOrderDTO(DiscountOnOrder entity) {
        discount= entity.getDiscount();


    }

    public Double getDiscount() {
        return discount;
    }




}
