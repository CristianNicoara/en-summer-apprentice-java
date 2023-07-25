package com.endava.TicketManagementSystem.dto;

import com.endava.TicketManagementSystem.model.Venue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventResponseDTO {
    private Integer id;
    private Venue venue;
    private String type;
    private String description;
    private String name;
    private Date startDate;
    private Date endDate;
    private List<TicketCategoryDTO> ticketCategories;
}
