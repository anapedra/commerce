package com.anapedra.commerce.entities;

import com.anapedra.commerce.entities.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID=1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOrder;
    private Instant moment;
    private Integer status;
    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private User client;
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items=new HashSet<>();

    public Order(Long id, LocalDate dateOrder, Instant moment, OrderStatus status,
                 Payment payment, User client) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.moment = moment;
         setStatus(status);
        this.payment = payment;
        this.client = client;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(status);
    }

    public void setStatus(OrderStatus status) {
        if (status != null){
            this.status = status.getCode();
        }
    }



    public Set<OrderItem> getItems() {
        return items;

    }
    public List<Product> getProducts(){
        return   items.stream().map(x->x.getProduct()).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
















