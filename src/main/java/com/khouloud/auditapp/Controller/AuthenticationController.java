package com.khouloud.auditapp.Controller;

import com.khouloud.auditapp.DTO.LoginRequest;
import com.khouloud.auditapp.DTO.LoginResponse;
import com.khouloud.auditapp.DTO.RegisterDTO;
import com.khouloud.auditapp.Entity.User;
import com.khouloud.auditapp.Service.UserService;
import com.khouloud.auditapp.security.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/authentification")
public class AuthenticationController {
    Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> register(@RequestBody LoginRequest loginUser) throws AuthenticationException {
        log.info("LoginRequest:{}", loginUser);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final User user = userService.findByUsername(loginUser.getUsername());
        if (user != null) {
            final String token = jwtTokenUtil.generateToken(user);
            return new ResponseEntity<LoginResponse>(new LoginResponse(token, user.getUsername()), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<LoginResponse>(new LoginResponse(null, null), HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterDTO registerForm) {
        if (!registerForm.getPassword().equals(registerForm.getRepassword()))
            throw new RuntimeException("you must confirm your password please !!!");
        User User = userService.findByUsername(registerForm.getUsername());
        if (User != null) throw new RuntimeException("this Client already exists");
        User user1 = new User();
        user1.setUsername(registerForm.getUsername());
        user1.setPassword(registerForm.getPassword());
        userService.saveUser(user1);
        userService.addRoleToClient(registerForm.getUsername(), "User");
        return user1;
    }
}
