package com.project1.TicketSystem.Repository;


import com.project1.TicketSystem.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
