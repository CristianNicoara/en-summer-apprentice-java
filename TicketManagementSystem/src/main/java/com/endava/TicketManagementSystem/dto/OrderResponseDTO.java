package com.endava.TicketManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
    private Integer eventId;
    private Date timestamp;
    private Integer ticketCategoryId;
    private Integer numberOfTickets;
    private Double totalPrice;
}
