package com.endava.TicketManagementSystem.repository;

import com.endava.TicketManagementSystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAll();

//    Order save(Order order);

    List<Order> findOrdersByCustomerId(Integer customerId);

    List<Order> findOrdersByTicketCategoryId(Integer ticketCategoryId);

}
