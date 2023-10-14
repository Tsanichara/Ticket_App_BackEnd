package com.project1.TicketSystem.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String username;

    private String password;

    private Boolean isAdmin;

    @OneToMany(mappedBy = "ticket_user")
    private List<Ticket> tickets;

}
