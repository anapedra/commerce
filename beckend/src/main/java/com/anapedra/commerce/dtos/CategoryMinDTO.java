package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.Category;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class CategoryMinDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String description;

    public CategoryMinDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }
    public CategoryMinDTO(Category entity) {
        id = entity.getId();
        description = entity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }



}
