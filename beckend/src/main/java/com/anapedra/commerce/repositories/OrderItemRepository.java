package com.anapedra.commerce.repositories;

import com.anapedra.commerce.entities.Order;
import com.anapedra.commerce.entities.OrderItem;
import com.anapedra.commerce.entities.pks.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
