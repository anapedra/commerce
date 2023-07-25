package com.anapedra.commerce.resources;

import com.anapedra.commerce.dtos.*;
import com.anapedra.commerce.services.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
@CrossOrigin(origins = "*",maxAge = 3600)
public class OrderResource {

    private final OrderService service;
    public OrderResource(OrderService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<Page<OrderDTO>> findAll(

            @RequestParam(value = "clientId",defaultValue = "0")Long clientId,
            @RequestParam(value = "nameClient",defaultValue = "") String nameClient,
            @RequestParam(value = "cpfClient",defaultValue = "") String cpfClient,
            @RequestParam(value = "minDate",defaultValue = "") String minDate,
            @RequestParam(value = "maxDate",defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<OrderDTO> list = service.find(clientId,nameClient,cpfClient,minDate,maxDate,pageable);
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findByI(@PathVariable Long id) {
        OrderDTO orderDTO = service.findById(id);
        return ResponseEntity.ok().body(orderDTO);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody @Valid OrderDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable Long id, @RequestBody @Valid OrderDTO dto) {
        OrderDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }






}
