package pl.uracz.workAccident.service;

import pl.uracz.workAccident.entity.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);
    Role findOneByName(String roleName);
    List<Role> findAll();
    boolean existsByName(String name);
}
