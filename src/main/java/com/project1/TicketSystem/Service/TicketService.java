package com.project1.TicketSystem.Service;


import com.project1.TicketSystem.Model.Ticket;
import com.project1.TicketSystem.Model.Users;
import com.project1.TicketSystem.Repository.TicketRepository;
import com.project1.TicketSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class TicketService {
    TicketRepository ticketRepository;
    UserRepository userRepository;
    @Autowired
    public TicketService(TicketRepository ticketRepository, UserRepository userRepository){
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    public Ticket addTicket(Ticket ticket, long userId){
        Users users = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        ticket.setTicket_user(users);

        Ticket savedTicket = ticketRepository.save(ticket);

        users.getTickets().add(savedTicket);
        userRepository.save(users);
        return savedTicket;
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(long id){
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        Ticket ticket = ticketOptional.get();

        return ticket;
    }

    public Ticket changeStatusToResolved(long id){
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        Ticket ticket = ticketOptional.get();
        ticket.setResolved(true);
        ticketRepository.save(ticket);
        return ticket;
    }
}
