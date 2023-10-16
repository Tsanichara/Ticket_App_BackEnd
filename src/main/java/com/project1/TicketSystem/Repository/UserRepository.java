package com.project1.TicketSystem.Repository;


import com.project1.TicketSystem.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    public Optional<Users> findUsersByUsername(String username);
}
