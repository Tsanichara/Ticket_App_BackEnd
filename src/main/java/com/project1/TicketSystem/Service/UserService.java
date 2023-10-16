package com.project1.TicketSystem.Service;

import com.project1.TicketSystem.Model.Ticket;
import com.project1.TicketSystem.Model.Users;
import com.project1.TicketSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Users shouldPermitLogin(Users account) {
        Optional<Users> usersOptional = userRepository.findUsersByUsername(account.getUsername());

        if (usersOptional.isPresent()) {
            Users users = usersOptional.get();

            if (account.getPassword().equals(users.getPassword())) {
                return users;
            }
        }

        return null;

    }

    public Users registerUser(Users account){
        if((!userRepository.findUsersByUsername(account.getUsername()).isPresent()) && (account.getPassword().length() > 4)){
            return userRepository.save(account);
        }
        return null;
    }

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    };


}
