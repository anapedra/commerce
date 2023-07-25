package com.anapedra.commerce.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID=1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant momentRegistration;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant momentUpdate;
    @Column(columnDefinition = "TEXT")
    private String shortDescription;
    @Lob
    private String fullDescription;
    private Double productCost;
    private Double initialPrice;
    private String imgUrl;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "tb_product_category",joinColumns =
    @JoinColumn(name = "product_id"),inverseJoinColumns =
    @JoinColumn(name = "category_id"))
    private Set<Category>categories=new HashSet<>();
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem>items=new HashSet<>();



    public Product(Long id, Instant momentRegistration, Instant momentUpdate, String shortDescription, String fullDescription, Double productCost,
                   Double initialPrice, String imgUrl) {
        this.id = id;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.productCost = productCost;
        this.initialPrice = initialPrice;
        this.imgUrl = imgUrl;

    }

    public Product() {

    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
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

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public Set<Category> getCategories() {
        return categories;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public List<Order> getOrders(){
        return items.stream().map(x->x.getOrder()).collect(Collectors.toList());
    }








}
