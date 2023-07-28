package com.anapedra.commerce.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_ship_price")
public class ShippingPriceTable implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double minPercentSP;
    private Double minPercentOtherStatesOfBrazilOutsideTheStateOfSP;

    public ShippingPriceTable(Long id, String description, Double minPercentSP, Double minPercentOtherStatesOfBrazilOutsideTheStateOfSP) {
        this.id = id;
        this.description = description;
        this.minPercentSP = minPercentSP;
        this.minPercentOtherStatesOfBrazilOutsideTheStateOfSP = minPercentOtherStatesOfBrazilOutsideTheStateOfSP;
    }

    public ShippingPriceTable() {

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
        if (!(o instanceof ShippingPriceTable)) return false;
        ShippingPriceTable that = (ShippingPriceTable) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
