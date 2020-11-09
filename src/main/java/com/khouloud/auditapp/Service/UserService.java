package com.khouloud.auditapp.Service;

import com.khouloud.auditapp.Entity.User;

public interface UserService {
    User saveUser(User clientapp);

    void addRoleToClient(String username, String roleName);

    User findByUsername(String username);
}
