package com.endava.TicketManagementSystem.service;

import com.endava.TicketManagementSystem.dto.GetOrderResponseDTO;
import com.endava.TicketManagementSystem.model.*;
import com.endava.TicketManagementSystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    TicketCategoryRepository ticketCategoryRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    VenueRepository venueRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public List<GetOrderResponseDTO> getOrdersByCustomerId(Integer customerId){
        List<Order> orders = orderRepository.findOrdersByCustomerId(customerId);
        List<GetOrderResponseDTO> orderResponses = new ArrayList<>();
        for (Order order : orders){
            Integer eventId = ticketCategoryRepository.findAllById(order.getTicketCategory().getId()).get(0).getEvent().getId();
            Date timestamp = order.getOrderedAt();
            Integer ticketCategoryId = order.getTicketCategory().getId();
            Integer numberOfTickets = order.getNumberOfTickets();
            Double totalPrice = order.getTotalPrice();
            GetOrderResponseDTO orderResponse = new GetOrderResponseDTO(eventId,timestamp,ticketCategoryId,numberOfTickets,totalPrice);
            orderResponses.add(orderResponse);
        }
        return orderResponses;
    }

    boolean validateOrder(Integer eventId, Integer numberOfTickets){
        int numberOfTicketsBought = 0;
        List<TicketCategory> ticketsForEvent = ticketCategoryRepository.findTicketCategoriesByEventId(eventId);
        for (TicketCategory ticket : ticketsForEvent){
            List<Order> ordersForTickets = orderRepository.findOrdersByTicketCategoryId(ticket.getId());
            for (Order order : ordersForTickets){
                numberOfTicketsBought += order.getNumberOfTickets();
            }
        }
        Event event = eventRepository.findEventById(eventId).get(0);
        Venue venue = venueRepository.findVenueById(event.getVenue().getId()).get(0);
        return numberOfTicketsBought + numberOfTickets <= venue.getCapacity();
    }

    public Order addOrder(Integer eventId, Integer ticketCategoryId, Integer numberOfTickets){
        Integer customerId = 5;
        if (validateOrder(eventId,numberOfTickets)) {
            Customer customer = customerRepository.findCustomerById(customerId).get(0);
            TicketCategory ticketCategory = ticketCategoryRepository.findAllById(ticketCategoryId).get(0);
            Double totalPrice = numberOfTickets * ticketCategory.getPrice();
            Order order = new Order(customer, ticketCategory, new Date(), numberOfTickets, totalPrice);
            return orderRepository.save(order);
        } else
            return null;
    }
}
