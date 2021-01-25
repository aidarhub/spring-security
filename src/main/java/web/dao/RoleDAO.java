package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> listRole();

    void addRole(Role role);

    void updateRole(Role role);

    void deleteRole(Role role);

    Role getRoleByRole(String role);
}
