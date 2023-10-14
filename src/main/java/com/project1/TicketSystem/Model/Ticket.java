package com.project1.TicketSystem.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketId;

    private String text;

    private Boolean resolved;


    @ManyToOne
    @JoinColumn(name = "user_fk")
    private Users ticket_user;

}
