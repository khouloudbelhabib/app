package com.khouloud.auditapp.Service;

import com.khouloud.auditapp.Entity.Role;
import com.khouloud.auditapp.Entity.User;

public interface UserService {
    public User saveUser (User clientapp);
    public void addRoleToClient(String username , String roleName);
    public User findByUsername(String username);
}
