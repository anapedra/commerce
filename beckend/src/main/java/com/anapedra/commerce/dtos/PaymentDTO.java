package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.Payment;
import com.anapedra.commerce.entities.enums.PaymentType;

import java.io.Serializable;
import java.time.Instant;

public class PaymentDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private Instant moment;
    private PaymentType paymentType;

    public PaymentDTO() {

    }

    public PaymentDTO(Long id, Instant moment, PaymentType paymentType) {
        this.id = id;
        this.moment = moment;
        this.paymentType = paymentType;
    }

    public PaymentDTO(Payment entity) {
        id = entity.getId();
        moment = entity.getMoment();
        paymentType=entity.getPaymentType();
    }


    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
