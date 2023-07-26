package com.anapedra.commerce.resources;

import com.anapedra.commerce.dtos.ProductCatalogDTO;
import com.anapedra.commerce.dtos.ProductDTO;
import com.anapedra.commerce.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping(value = "/products")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ProductResource {
        private ProductService service;

        public ProductResource(ProductService service) {
            this.service = service;
        }


    @GetMapping
    public ResponseEntity<Page<ProductCatalogDTO>> findAll(
            @RequestParam(value = "categoryId", defaultValue = "0") Long categoryId,
            @RequestParam(value = "descriptionCategory", defaultValue = "") String descriptionCategory,
            @RequestParam(value = "descriptionProduct", defaultValue = "") String descriptionProduct,
            Pageable pageable) {
        Page<ProductCatalogDTO> list = service.catalog(categoryId,descriptionCategory,descriptionProduct.trim() ,pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductCatalogDTO> findProductCtalogById(@PathVariable Long id) {
        ProductCatalogDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
        public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) {
            dto = service.insert(dto);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(dto.getId()).toUri();
            return ResponseEntity.created(uri).body(dto);
        }

        @PutMapping(value = "/{id}")
        public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
            dto = service.update(id, dto);
            return ResponseEntity.ok().body(dto);
        }

        @DeleteMapping(value = "/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
    }





