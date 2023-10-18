package com.project1.TicketSystem.Controller;


import com.project1.TicketSystem.Model.Ticket;
import com.project1.TicketSystem.Service.TicketService;
import com.project1.TicketSystem.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TicketController {
    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){

        this.ticketService = ticketService;
    }

    @PostMapping("/ticket")
    public ResponseEntity<Ticket> postTicket(@RequestBody Ticket ticket, @RequestParam Long userId){
        Ticket createdTicket = ticketService.addTicket(ticket, userId);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @GetMapping("/ticket")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PatchMapping("/ticket/{id}")
    public Ticket resolveTicket(@PathVariable long id){
        return ticketService.changeStatusToResolved((id));
    }
}
