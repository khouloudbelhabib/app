package com.khouloud.auditapp.Controller;

import com.khouloud.auditapp.Service.UserService;
import com.khouloud.auditapp.entities.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public User register(@RequestBody RegisterForm registerForm){
        if(!registerForm.getPassword().equals(registerForm.getRepassword()))
            throw new RuntimeException("you must confirm your password please !!!");
          User User = userService.findClientbyUsername(registerForm.getUsername());
          if(User !=null) throw  new RuntimeException("this Client already exists");
          User user1 = new User();
          user1.setUsername(registerForm.getUsername());
          user1.setPassword(registerForm.getPassword());
          userService.saveUser(user1);
          userService.addRoleToClient(registerForm.getUsername(),"User");
          return user1;
    }

}
