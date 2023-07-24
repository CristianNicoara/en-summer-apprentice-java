package com.endava.TicketManagementSystem.controller;

import com.endava.TicketManagementSystem.dto.EventResponseDTO;
import com.endava.TicketManagementSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("")
    public List<EventResponseDTO> getEventsByVenueIdAndEventTypeName(@RequestParam Integer venueId, @RequestParam String eventTypeName){
        return eventService.getEventsByVenueIdAndEventTypeName(venueId,eventTypeName);
    }

}
