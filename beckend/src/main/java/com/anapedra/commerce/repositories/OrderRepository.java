package com.anapedra.commerce.repositories;

import com.anapedra.commerce.entities.Order;
import com.anapedra.commerce.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {


    @Query("SELECT DISTINCT obj FROM Order obj INNER JOIN obj.client cli  WHERE " +
            "(COALESCE(:client) IS NULL OR cli IN :client) AND " +
            " (LOWER(obj.client.name) LIKE LOWER(CONCAT('%',:nameClint,'%'))) AND" +
            " (LOWER(obj.client.cpf) LIKE LOWER(CONCAT('%',:cpfClient,'%'))) AND " +
            "obj.dateOrder BETWEEN :min AND :max  ")
    Page<Order> find(User client, String nameClint, String cpfClient, LocalDate min, LocalDate max, Pageable pageable);
    @Query("SELECT obj FROM Order obj JOIN FETCH obj.client  WHERE obj IN :orders ")
    List<Order> findOrder(List<Order> orders);


    @Query("SELECT obj FROM Order obj WHERE " +
            "obj.dateOrder BETWEEN :min AND :max and " +
            "(LOWER(obj.client.name) LIKE LOWER(CONCAT('%',:nameClint,'%'))) ")
    Page<Order> findOrderbyNameClient(LocalDate min, LocalDate max,String nameClint , Pageable pageable);

    @Query("SELECT obj FROM Order obj WHERE " +
            "obj.dateOrder BETWEEN :min AND :max ")
    List<Order> findSummary(LocalDate min, LocalDate max);


    @Query("SELECT obj FROM Order obj WHERE " +
            "obj.dateOrder BETWEEN :min AND :max ")
    List<Order> sumSale(LocalDate min, LocalDate max);


}












