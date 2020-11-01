package com.khouloud.auditapp.Service.impl;

import com.khouloud.auditapp.Controller.AuthenticationController;
import com.khouloud.auditapp.Repository.UserRepository;
import com.khouloud.auditapp.Repository.RoleRepository;
import com.khouloud.auditapp.Service.UserService;
import com.khouloud.auditapp.Entity.Role;
import com.khouloud.auditapp.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User clientapp) {
        String hashPW = bCryptPasswordEncoder.encode(clientapp.getPassword());
        clientapp.setPassword(hashPW);
        return userRepository.save(clientapp);
    }

    @Override
    public void addRoleToClient(String username, String roleName) {
        Role role = roleRepository.findByRoleName(roleName);
        User User = userRepository.findByUsername(username);
        User.getRole().add(role);
    }

    @Override
    public User  findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("------->   " + username);
        User user = findByUsername(username);
        System.out.println("------->   " + user.getId());

        if (user == null) throw new UsernameNotFoundException(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRole().forEach(r -> {
            log.info("rolee :{}",r);

            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
        System.out.println("--ruser.getUsername()rr----->   " + user.getUsername());
        System.out.println("--getPassword----->   " + user.getPassword());
        System.out.println("--authorities----->   " +authorities);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
