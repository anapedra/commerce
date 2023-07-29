package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.Order;
import com.anapedra.commerce.entities.OrderItem;
import com.anapedra.commerce.entities.enums.OrderStatus;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class OrderDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Instant moment;
    private Long id;
    private OrderStatus status;
    private Integer totalProduct;
    private LocalDate dateOrder;
    private Double total;
    private PaymentDTO payment;
    private ShipDTO ship;
    private DiscountOnOrderDTO discount;
    private ClientDTO client;
    @NotEmpty(message = "Deverá conter ao menos um item no pedido")
    private List<OrderItemDTO>items=new ArrayList<>();

    public OrderDTO(){

    }

    public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment,LocalDate dateOrder, ShipDTO ship,DiscountOnOrderDTO discount) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
        this.dateOrder=dateOrder;
        this.ship=ship;
        this.discount=discount;
    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
        status = (entity.getPayment()==null) ? OrderStatus.WAITING_PAYMENT : entity.getStatus();                             ;
        client = new ClientDTO(entity.getClient());
        payment = (entity.getPayment()==null) ? null : new PaymentDTO(entity.getPayment());
        ship=(entity.getShip()==null) ? null : new ShipDTO(entity.getShip());
        discount=(entity.getDiscount()==null) ? null : new DiscountOnOrderDTO(entity.getDiscount());
        totalProduct = entity.getQuantityProduct();
        dateOrder=entity.getDateOrder();
        total = entity.getTotal();
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

    public ShipDTO getShip() {
        return ship;
    }

    public void setShip(ShipDTO ship) {
        this.ship = ship;
    }

    public DiscountOnOrderDTO getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountOnOrderDTO discount) {
        this.discount = discount;
    }

    public Integer getTotalProduct() {
        return totalProduct;
    }

    public Double getTotal() {
        return total;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
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
