package com.endava.TicketManagementSystem.service;

import com.endava.TicketManagementSystem.dto.EventResponseDTO;
import com.endava.TicketManagementSystem.dto.TicketCategoryDTO;
import com.endava.TicketManagementSystem.model.Event;
import com.endava.TicketManagementSystem.model.TicketCategory;
import com.endava.TicketManagementSystem.model.Venue;
import com.endava.TicketManagementSystem.repository.EventRepository;
import com.endava.TicketManagementSystem.repository.TicketCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketCategoryRepository ticketCategoryRepository;

    public List<EventResponseDTO> getEventsByVenueIdAndEventTypeName(Integer venueId, String eventTypeName){
        List<Event> events = eventRepository.findEventsByVenueIdAndEventTypeName(venueId,eventTypeName);
        List<EventResponseDTO> eventResponses = new ArrayList<>();
        for (Event event : events) {
            Integer eventId = event.getId();
            Venue venue = event.getVenue();
            String description = event.getDescription();
            String name = event.getName();
            Date startDate = event.getStartDate();
            Date endDate = event.getEndDate();
            List<TicketCategory> ticketCategories = ticketCategoryRepository.findTicketCategoriesByEventId(eventId);
            List<TicketCategoryDTO> ticketCategoryDTOs = new ArrayList<>();
            for (TicketCategory ticketCategory : ticketCategories){
                TicketCategoryDTO ticketCategoryDTO = new TicketCategoryDTO(ticketCategory.getId(), ticketCategory.getDescription(), ticketCategory.getPrice());
                ticketCategoryDTOs.add(ticketCategoryDTO);
            }
            EventResponseDTO eventResponse = new EventResponseDTO(eventId,venue,eventTypeName,description,name,startDate,endDate,ticketCategoryDTOs);
            eventResponses.add(eventResponse);
        }
        return eventResponses;
    }
}
