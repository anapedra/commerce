package com.anapedra.commerce.entities;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_ship")
public class Ship implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @MapsId
    private Order order;
    @ManyToOne
    @JoinColumn(name = "shippingPriceTableId")
    private ShippingPriceTable shippingPriceTable;

    public Ship(Long id, Order order, ShippingPriceTable shippingPriceTable) {
        this.id = id;
        this.order = order;
        this.shippingPriceTable = shippingPriceTable;
    }

    public Ship() {

    }

    public LocalDate getExpectedShipDate(){
       LocalDate expectedShipDate=null;
       if (order.getPayment()!= null && order.getClient().getAddressState().equalsIgnoreCase("SP")){
           expectedShipDate=order.getDateOrder().plusDays(10);
       }
       else if (order.getPayment()!= null && !order.getClient().getAddressState().equalsIgnoreCase("SP") &&
               order.getClient().getAddressCountry().equalsIgnoreCase("BR")){
           expectedShipDate=order.getDateOrder().plusDays(30);
       }
       return expectedShipDate;

    }

    public Double getShipCost(){
        double shipCost=0.0;
        if (order.getClient().getAddressState().equalsIgnoreCase("SP")){

            shipCost= order.getTotal()*shippingPriceTable.getMinPercentSP();

        }else if (!order.getClient().getAddressState().equalsIgnoreCase("SP") &&
                order.getClient().getAddressCountry().equalsIgnoreCase("BR")){

              shipCost= order.getTotal()*shippingPriceTable.getMinPercentOtherStatesOfBrazilOutsideTheStateOfSP();
        }
        return shipCost;
    }

    public String getCepShipAddress(){
        return order.getClient().getAddressCep();
    }

    public Integer getNumberShipAddress(){
        return order.getClient().getAddressNumber();
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

    public ShippingPriceTable getShippingPriceTable() {
        return shippingPriceTable;
    }

    public void setShippingPriceTable(ShippingPriceTable shippingPriceTable) {
        this.shippingPriceTable = shippingPriceTable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ship)) return false;
        Ship ship = (Ship) o;
        return Objects.equals(getId(), ship.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
