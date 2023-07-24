package com.endava.TicketManagementSystem.repository;

import com.endava.TicketManagementSystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findEventsByVenueIdAndEventTypeName(@Param("venue_id")Integer venueId, @Param("event_type")String eventTypeName);

    Event findEventById(Integer eventId);
}
