package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.Payment;

import java.io.Serializable;
import java.time.Instant;

public class PaymentDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private Instant moment;

    public PaymentDTO() {

    }

    public PaymentDTO(Long id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }
    public PaymentDTO(Payment entity) {
        id = entity.getId();
        moment = entity.getMoment();
    }


    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }


}
