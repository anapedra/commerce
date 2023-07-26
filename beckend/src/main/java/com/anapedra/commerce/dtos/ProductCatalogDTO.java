package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.Category;
import com.anapedra.commerce.entities.Product;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductCatalogDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String shortDescription;
    @NotBlank(message = "Campo obrigatório")
    private Double initialPrice;
    @NotBlank(message = "Campo obrigatório")
    private String imgUrl;
    private List<CategoryMinDTO> categories=new ArrayList<>();
    public ProductCatalogDTO() {

    }

    public ProductCatalogDTO(Long id, String shortDescription, Double initialPrice, String imgUrl) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.initialPrice = initialPrice;
        this.imgUrl = imgUrl;
    }

    public ProductCatalogDTO(Product entity) {
        id = entity.getId();
        shortDescription = entity.getShortDescription();
        initialPrice = entity.getInitialPrice();
        imgUrl = entity.getImgUrl();
    }
    public ProductCatalogDTO(Product entity, Set<Category> categories){
        this(entity);
        entity.getCategories().forEach(category -> this.categories.add(new CategoryMinDTO(category)));
    }

    public Long getId() {
        return id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryMinDTO> getCategories() {
        return categories;
    }
}
