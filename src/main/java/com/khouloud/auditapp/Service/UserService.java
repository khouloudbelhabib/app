package com.khouloud.auditapp.Service;

import com.khouloud.auditapp.entities.Role;
import com.khouloud.auditapp.entities.User;

public interface UserService {
    public User saveUser (User clientapp);
    public Role saveRole (Role role);
    public void addRoleToClient(String username , String roleName);
    public User findClientbyUsername(String username);
}
