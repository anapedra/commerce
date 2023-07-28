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

    private Long id;
    private Long shipPriceTableId;
    private LocalDate expectedShipDate;
    private Double shipCost;
    private String cepShipAddress;
    private Integer numberShipAddress;


    public ShipDTO() {

    }

    public ShipDTO(Long id, Long shipPriceTableId) {
        this.id = id;
        this.shipPriceTableId = shipPriceTableId;
    }

    public ShipDTO(Ship entity){
     id=entity.getOrder().getId();
     shipPriceTableId=entity.getOrder().getId();
     expectedShipDate=entity.getExpectedShipDate();
     shipCost= entity.getShipCost();
     cepShipAddress=entity.getCepShipAddress();
     numberShipAddress=entity.getNumberShipAddress();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShipPriceTableId() {
        return shipPriceTableId;
    }

    public void setShipPriceTableId(Long shipPriceTableId) {
        this.shipPriceTableId = shipPriceTableId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShipDTO)) return false;
        ShipDTO shipDTO = (ShipDTO) o;
        return Objects.equals(id, shipDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
