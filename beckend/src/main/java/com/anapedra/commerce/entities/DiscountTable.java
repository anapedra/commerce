package com.anapedra.commerce.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_discount_table")
public class DiscountTable implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 300)
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant momentRegistration;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant momentUpdate;
    private Double minDiscountPercentage;
    private Double maxDiscountPercentage;

    public DiscountTable(Long id, String description, Instant momentRegistration,
                         Instant momentUpdate, Double minDiscountPercentage, Double maxDiscountPercentage) {
        this.id = id;
        this.description = description;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.minDiscountPercentage = minDiscountPercentage;
        this.maxDiscountPercentage = maxDiscountPercentage;
    }

    public DiscountTable() {

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
        if (!(o instanceof DiscountTable)) return false;
        DiscountTable that = (DiscountTable) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
