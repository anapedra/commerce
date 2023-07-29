package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.DiscountTable;

import javax.persistence.Column;
import java.time.Instant;
import java.util.Objects;

public class DiscountTableDTO {

    private Long id;
    @Column(length = 300)
    private String description;
    private Instant momentRegistration;
    private Instant momentUpdate;
    private Double minDiscountPercentage;
    private Double maxDiscountPercentage;

    public DiscountTableDTO() {

    }

    public DiscountTableDTO(Long id, String description, Instant momentRegistration, Instant momentUpdate,
                            Double minDiscountPercentage, Double maxDiscountPercentage) {
        this.id = id;
        this.description = description;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.minDiscountPercentage = minDiscountPercentage;
        this.maxDiscountPercentage = maxDiscountPercentage;
    }
    public DiscountTableDTO(DiscountTable entity){
        id = entity.getId();
        description = entity.getDescription();
        momentRegistration = entity.getMomentRegistration();
        momentUpdate = entity.getMomentUpdate();
        minDiscountPercentage = entity.getMinDiscountPercentage();
        maxDiscountPercentage = entity.getMaxDiscountPercentage();
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

    public Instant getMomentRegistration() {
        return momentRegistration;
    }

    public void setMomentRegistration(Instant momentRegistration) {
        this.momentRegistration = momentRegistration;
    }

    public Instant getMomentUpdate() {
        return momentUpdate;
    }

    public void setMomentUpdate(Instant momentUpdate) {
        this.momentUpdate = momentUpdate;
    }

    public Double getMinDiscountPercentage() {
        return minDiscountPercentage;
    }

    public void setMinDiscountPercentage(Double minDiscountPercentage) {
        this.minDiscountPercentage = minDiscountPercentage;
    }

    public Double getMaxDiscountPercentage() {
        return maxDiscountPercentage;
    }

    public void setMaxDiscountPercentage(Double maxDiscountPercentage) {
        this.maxDiscountPercentage = maxDiscountPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountTableDTO)) return false;
        DiscountTableDTO that = (DiscountTableDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
