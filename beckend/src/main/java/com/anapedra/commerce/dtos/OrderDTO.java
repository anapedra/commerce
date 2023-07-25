package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.Order;
import com.anapedra.commerce.entities.OrderItem;
import com.anapedra.commerce.entities.enums.OrderStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class OrderDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;
    private Instant moment;
    private OrderStatus status;
    private ClientDTO client;
    private PaymentDTO payment;
    private Integer totalProduct;
    private Double total;
    private List<OrderItemDTO>items=new ArrayList<>();

    public OrderDTO(){

    }

    public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.status = entity.getStatus();
        this.client = new ClientDTO(entity.getClient());
        this.payment = (entity.getPayment()==null) ? null : new PaymentDTO(entity.getPayment());
        this.totalProduct = entity.getQuantityProduct();
        this.total = entity.getTotal();
    }


    public OrderDTO(Order entity, Set<OrderItem> orderItems){
        this(entity);
        entity.getItems().forEach(orderItem -> this.items.add(new OrderItemDTO(orderItem)));

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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public Integer getTotalProduct() {
        return totalProduct;
    }

    public Double getTotal() {
        return total;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDTO)) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
