package com.project1.TicketSystem.Repository;


import com.project1.TicketSystem.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
