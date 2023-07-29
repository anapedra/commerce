package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.Payment;
import com.anapedra.commerce.entities.enums.OrderStatus;
import com.anapedra.commerce.entities.enums.PaymentType;

import java.io.Serializable;
import java.time.Instant;

public class PaymentDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private Instant moment;
    private PaymentType paymentType;
    private Double totalPayment;

    public PaymentDTO() {

    }

    public PaymentDTO(Instant moment, PaymentType paymentType) {
        this.moment = moment;
        this.paymentType = paymentType;
    }

    public PaymentDTO(Payment entity) {
        moment = entity.getMoment();
        paymentType=entity.getPaymentType();
        totalPayment= (entity.getOrder().getShip()==null) ? entity.getOrder().getTotal() : entity.getTotalPayment();
    }


    public Instant getMoment() {
        return moment;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }
}
