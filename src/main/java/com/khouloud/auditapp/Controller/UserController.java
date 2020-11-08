package com.khouloud.auditapp.Controller;

import com.khouloud.auditapp.Entity.User;
import com.khouloud.auditapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getByUsername/{username}")
    public User getByUsername(@PathVariable String username) {
        System.out.println("username "+userService.findByUsername(username));
        return userService.findByUsername(username);
    }
}
