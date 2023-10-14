package com.project1.TicketSystem.Controller;


import com.project1.TicketSystem.Model.Ticket;
import com.project1.TicketSystem.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {
    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping("/ticket")
    public Ticket postTicket(@RequestBody Ticket ticket){
        return ticketService.addTicket(ticket);
    }

    @GetMapping("/ticket")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }
}
