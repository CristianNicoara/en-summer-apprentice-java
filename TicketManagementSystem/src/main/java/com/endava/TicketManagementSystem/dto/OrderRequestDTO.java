package com.endava.TicketManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    private Integer eventId;
    private Integer ticketCategoryId;
    private Integer numberOfTickets;
}
