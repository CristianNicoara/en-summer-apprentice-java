package com.endava.TicketManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events", schema = "ticket_management_system")
public class Event {
    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="venue_id", referencedColumnName="venue_id", foreignKey=@ForeignKey(name = "FK_events_venue"))
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "event_type_id", referencedColumnName = "event_type_id", foreignKey = @ForeignKey(name = "FK_events_event_type"))
    private EventType eventType;

    @Column(name = "event_description", length = 50)
    private String description;

    @Column(name = "event_name", length = 50)
    private String name;

    @Column(name = "event_start_date")
    private Date startDate;

    @Column(name = "event_end_date")
    private Date endDate;
}
