package com.project1.TicketSystem.Controller;

import com.project1.TicketSystem.Model.Users;
import com.project1.TicketSystem.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    UserService userService;

    @Autowired
    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<Users> attemptRegistration(@RequestBody Users account){
        Users persistedUser = userService.registerUser(account);

        if(persistedUser != null) {
            return new ResponseEntity<Users>(persistedUser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Users>((Users) null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Users> attemptLogin(@RequestBody Users account){
        Users persistedUser = userService.shouldPermitLogin(account);
        if (persistedUser != null){
            return new ResponseEntity<Users>(persistedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<Users>((Users) null, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }
}
