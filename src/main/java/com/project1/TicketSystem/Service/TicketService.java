package com.project1.TicketSystem.Service;


import com.project1.TicketSystem.Model.Ticket;
import com.project1.TicketSystem.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class TicketService {
    TicketRepository ticketRepository;
    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public Ticket addTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
}
