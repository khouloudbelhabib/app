package com.khouloud.auditapp.Repository;

import com.khouloud.auditapp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository  extends JpaRepository<Role,Long> {
    public Role findByRoleName(String  role);
}
