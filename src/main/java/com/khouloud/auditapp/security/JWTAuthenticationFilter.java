package com.khouloud.auditapp.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khouloud.auditapp.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)throws AuthenticationException {
        User Client =null;
        try{
        Client=new ObjectMapper().readValue(request.getInputStream(), User.class);}
        catch (Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("**********");
        System.out.println("username:"+Client.getUsername());
        System.out.println(("password:"+Client.getPassword()));
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(Client.getUsername(),Client.getPassword()));
    }
    protected void successfulAuthentication (HttpServletRequest request, HttpServletResponse response, Authentication authResult)throws IOException,ServletException{
        User springUser = (User) authResult.getPrincipal();
        String jwt= Jwts.builder().setSubject(springUser.getUsername())
                .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256,SecurityConstants.SECRET)
                .claim("role", springUser.getRole())
                .compact();
        response.addHeader(SecurityConstants.HEADER_STRING,SecurityConstants.TOKEN_PREFIX+jwt);
    }
}


