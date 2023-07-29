package com.anapedra.commerce.entities;

import com.anapedra.commerce.entities.enums.PaymentType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_discount_on_order")
public class DiscountOnOrder implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final Double TOTAL_MIN_DISCOUNT=150.0;
    @OneToOne
    @MapsId
    private Order order;
    @ManyToOne
    @JoinColumn(name = "discountTableId")
    private DiscountTable discountTable;

    public DiscountOnOrder(Long id, Order order, DiscountTable discountTable) {
        this.id = id;
        this.order = order;
        this.discountTable = discountTable;
    }

    public DiscountOnOrder() {

    }

    public double getDiscount(){
       if (order.getTotal() >= TOTAL_MIN_DISCOUNT  && order.getTotal() <=  TOTAL_MIN_DISCOUNT * 2 &&
               order.getPayment().getPaymentType() == PaymentType.PIX){
           return order.getTotal() * discountTable.getMinDiscountPercentage();
       }
       else if (order.getTotal() > TOTAL_MIN_DISCOUNT * 2 &&
               order.getPayment().getPaymentType() == PaymentType.PIX){
           return order.getTotal() * discountTable.getMaxDiscountPercentage();
       }
       return 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public DiscountTable getDiscountTable() {
        return discountTable;
    }

    public void setDiscountTable(DiscountTable discountTable) {
        this.discountTable = discountTable;
    }

    public Double getTOTAL_MIN_DISCOUNT() {
        return TOTAL_MIN_DISCOUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountOnOrder)) return false;
        DiscountOnOrder that = (DiscountOnOrder) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
