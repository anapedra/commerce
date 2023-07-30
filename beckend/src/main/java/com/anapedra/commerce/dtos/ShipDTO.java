package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.Address;
import com.anapedra.commerce.entities.Order;
import com.anapedra.commerce.entities.Ship;
import com.anapedra.commerce.entities.ShippingPriceTable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ShipDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private LocalDate expectedShipDate;
    private Double shipCost;
    private String cepShipAddress;
    private Integer numberShipAddress;


    public ShipDTO(Ship entity){
     expectedShipDate=entity.getExpectedShipDate();
     shipCost= entity.getShipCost();
     cepShipAddress=entity.getCepShipAddress();
     numberShipAddress=entity.getNumberShipAddress();

    }


    public LocalDate getExpectedShipDate() {
        return expectedShipDate;
    }

    public Double getShipCost() {
        return shipCost;
    }

    public String getCepShipAddress() {
        return cepShipAddress;
    }

    public Integer getNumberShipAddress() {
        return numberShipAddress;
    }


}
