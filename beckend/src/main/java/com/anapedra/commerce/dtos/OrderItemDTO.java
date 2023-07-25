package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.OrderItem;

import java.io.Serializable;
import java.util.Objects;

public class OrderItemDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private Long productId;
    private String shotDescription;
    private Double price;
    private Integer quantity;
    private Double subTotal;
    private String imgUrl;

    public OrderItemDTO() {

    }

    public OrderItemDTO(Long productId, String shotDescription, Double price, Integer quantity,String imgUrl) {
        this.productId = productId;
        this.shotDescription = shotDescription;
        this.price = price;
        this.quantity = quantity;
        this.imgUrl=imgUrl;

    }

    public OrderItemDTO(OrderItem entity) {
       productId = entity.getProduct().getId();
       shotDescription = entity.getProduct().getShortDescription();
       price = entity.getPrice();
       quantity = entity.getQuantity();
       subTotal=entity.getSubTotal();
       imgUrl=entity.getProduct().getImgUrl();

    }

    public Long getProductId() {
        return productId;
    }

    public String getShotDescription() {
        return shotDescription;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public String getImgUrl() {
        return imgUrl;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemDTO)) return false;
        OrderItemDTO that = (OrderItemDTO) o;
        return Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
