package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> listRole();

    void addRole(Role role);

    void updateRole(Role role);

    void deleteRole(Role role);

    Role getRoleByRole(String role);
}
