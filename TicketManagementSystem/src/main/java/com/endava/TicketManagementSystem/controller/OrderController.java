package com.endava.TicketManagementSystem.controller;

import com.endava.TicketManagementSystem.dto.GetOrderResponseDTO;
import com.endava.TicketManagementSystem.dto.OrderRequestDTO;
import com.endava.TicketManagementSystem.dto.OrderResponseDTO;
import com.endava.TicketManagementSystem.model.Order;
import com.endava.TicketManagementSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("")
    public List<GetOrderResponseDTO> getOrdersByCustomerId(){
        Integer customerId = 4;
        return orderService.getOrdersByCustomerId(customerId);
    }

    @PostMapping("/add")
    public OrderResponseDTO addOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        Integer eventId = orderRequestDTO.getEventId();
        Integer ticketCategoryId = orderRequestDTO.getTicketCategoryId();
        Integer numberOfTickets = orderRequestDTO.getNumberOfTickets();
        Order order = orderService.addOrder(eventId, ticketCategoryId,numberOfTickets);
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO(eventId,order.getOrderedAt(),ticketCategoryId,numberOfTickets,order.getTotalPrice());
        return  orderResponseDTO;
    }
}
