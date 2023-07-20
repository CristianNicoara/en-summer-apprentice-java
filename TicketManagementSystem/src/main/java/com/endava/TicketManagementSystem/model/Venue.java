package com.endava.TicketManagementSystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "venue", schema = "ticket_management_system")
public class Venue {

    @Id
    @Column(name = "venue_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "venue_location")
    private String location;

    @Column(name = "venue_type")
    private String type;

    @Column(name = "venue_capacity")
    private Integer capacity;

}
