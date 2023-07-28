package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.ShippingPriceTable;

import java.io.Serializable;
import java.util.Objects;

public class ShipPriceTableDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;
    private String description;
    private Double minPercentSP;
    private Double minPercentOtherStatesOfBrazilOutsideTheStateOfSP;

    public ShipPriceTableDTO() {

    }

    public ShipPriceTableDTO(Long id, String description, Double minPercentSP, Double minPercentOtherStatesOfBrazilOutsideTheStateOfSP) {
        this.id = id;
        this.description = description;
        this.minPercentSP = minPercentSP;
        this.minPercentOtherStatesOfBrazilOutsideTheStateOfSP = minPercentOtherStatesOfBrazilOutsideTheStateOfSP;
    }

    public ShipPriceTableDTO(ShippingPriceTable entity) {
    id=entity.getId();
    description=entity.getDescription();
    minPercentSP=entity.getMinPercentSP();
    minPercentOtherStatesOfBrazilOutsideTheStateOfSP=entity.getMinPercentOtherStatesOfBrazilOutsideTheStateOfSP();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Double getMinPercentSP() {
        return minPercentSP;
    }

    public void setMinPercentSP(Double minPercentSP) {
        this.minPercentSP = minPercentSP;
    }

    public Double getMinPercentOtherStatesOfBrazilOutsideTheStateOfSP() {
        return minPercentOtherStatesOfBrazilOutsideTheStateOfSP;
    }

    public void setMinPercentOtherStatesOfBrazilOutsideTheStateOfSP(Double minPercentOtherStatesOfBrazilOutsideTheStateOfSP) {
        this.minPercentOtherStatesOfBrazilOutsideTheStateOfSP = minPercentOtherStatesOfBrazilOutsideTheStateOfSP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShipPriceTableDTO)) return false;
        ShipPriceTableDTO that = (ShipPriceTableDTO) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
