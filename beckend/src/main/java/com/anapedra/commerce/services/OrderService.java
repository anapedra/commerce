package com.anapedra.commerce.services;

import com.anapedra.commerce.dtos.OrderDTO;
import com.anapedra.commerce.dtos.OrderItemDTO;
import com.anapedra.commerce.entities.Order;
import com.anapedra.commerce.entities.OrderItem;
import com.anapedra.commerce.entities.Product;
import com.anapedra.commerce.entities.User;
import com.anapedra.commerce.entities.enums.OrderStatus;
import com.anapedra.commerce.repositories.OrderItemRepository;
import com.anapedra.commerce.repositories.OrderRepository;
import com.anapedra.commerce.repositories.ProductRepository;
import com.anapedra.commerce.repositories.UserRepository;
import com.anapedra.commerce.services.exceptionservice.DataBaseException;
import com.anapedra.commerce.services.exceptionservice.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final AuthService authService;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    public OrderService(AuthService authService,
                        OrderRepository orderRepository,
                        UserRepository userRepository,
                        UserService userService,
                        OrderItemRepository orderItemRepository,
                        ProductRepository productRepository) {
        this.authService = authService;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }


    @Transactional(readOnly = true)
    public Page<OrderDTO> find(Long clientId, String nameClient,String cpfClient, String minDate, String maxDate, Pageable pageable){
        authService.validateAdmin();
        User client=(clientId == 0) ? null : userRepository.getOne(clientId);
        LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
        Page<Order> page=orderRepository.find(client,nameClient,cpfClient,min,max,pageable);
        orderRepository.findOrder(page.stream().collect(Collectors.toList()));
        return page.map(OrderDTO::new);
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order entity = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Entity not found"));
       authService.validateSelfOrAdmin(entity.getClient().getId());
        return new OrderDTO(entity,entity.getItems());

    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        authService.validateClient();
        Order entity = new Order();
        entity.setDateOrder(LocalDate.now());
        entity.setMoment(Instant.now());
        copyDtoToEntity(dto, entity);
        entity = orderRepository.save(entity);
        return new OrderDTO(entity);

    }

    @Transactional
    public OrderDTO update(Long id, OrderDTO dto) {

        try {
            Order entity = orderRepository.getOne(id);
            authService.validateAdmin();
            copyDtoToEntity(dto, entity);
            entity = orderRepository.save(entity);
            return new OrderDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        authService.validateAdmin();
        try {
            orderRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(OrderDTO dto, Order entity){

        entity.setDateOrder(LocalDate.now());
        entity.setMoment(Instant.now());
        entity.setStatus(OrderStatus.WAITING_PAYMENT);
        User user=authService.authenticated();
        entity.setClient(user);

        entity.getItems().clear();
        for (OrderItemDTO orderItemDTO: dto.getItems()){
            Product product=productRepository.getOne(orderItemDTO.getProductId());
            OrderItem orderItem=new OrderItem(entity,product, orderItemDTO.getQuantity(), product.getInitialPrice());
            entity.getItems().add(orderItem);
        }
        orderRepository.save(entity);
        orderItemRepository.saveAll(entity.getItems());




    }


/*
    @Transactional(readOnly = true)
    public List<SalesClientSellerDTO> findSummaryOserClientSellers(String minDate, String maxDate){
        LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
        long days = ChronoUnit.DAYS.between(min,max);
        SalesClientSellerDTO clientSellerDTO=new SalesClientSellerDTO();
        clientSellerDTO.setAverageSales(clientSellerDTO.getTotal()/days) ;
        List<Order> list=orderRepository.findSummary(min,max);
        return list.stream().map(SalesClientSellerDTO::new).collect(Collectors.toList());
    }

 */

}
