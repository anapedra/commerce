package com.anapedra.commerce.entities;

import com.anapedra.commerce.entities.enums.PaymentType;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {
    private static final long serialVersionUID=1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 //   @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
   @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant moment;
    @OneToOne
    @MapsId
    private Order order;
    private Integer paymentType;


    public Payment(Long id, Instant moment, Order order,PaymentType paymentType) {
        this.id = id;
        this.moment = moment;
        this.order = order;
        setPaymentType(paymentType);
    }

    public Payment() {

    }

    public Double getTotalPayment(){

        if (order.getShip()!=null && order.getDiscountOnOrder() !=null){
        return order.getTotal()-order.getDiscountOnOrder().getDiscount() + (order.getShip().getShipCost());
        }
        else if (order.getShip()!=null && order.getDiscountOnOrder()==null) {
            return order.getTotal() + order.getShip().getShipCost();
        }
        else if (order.getDiscountOnOrder()!=null && order.getShip()==null){
            return order.getTotal()-order.getDiscountOnOrder().getDiscount();
        }
        else {
            return order.getTotal();
        }


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PaymentType getPaymentType() {
        return PaymentType.valueOf(paymentType);
    }

    public void setPaymentType(PaymentType paymentType) {
        if (paymentType!= null){
            this. paymentType =  paymentType.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Objects.equals(getId(), payment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
