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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders", schema = "ticket_management_system")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName="customer_id", foreignKey=@ForeignKey(name = "FK_orders_customer"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ticket_category_id", referencedColumnName = "ticket_category_id", foreignKey = @ForeignKey(name = "FK_orders_ticket_category"))
    private TicketCategory ticketCategory;

    @Column(name = "ordered_at")
    private Date orderedAt;

    @Column(name = "number_of_tickets")
    private Integer numberOfTickets;

    @Column(name = "total_price")
    private Double totalPrice;
}
