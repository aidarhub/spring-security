package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDAO;
import web.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDAO roleDAO;

    @Transactional(readOnly = true)
    @Override
    public List<Role> listRole() {
        return roleDAO.listRole();
    }

    @Transactional
    @Override
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }

    @Transactional
    @Override
    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }

    @Transactional
    @Override
    public void deleteRole(Role role) {
        roleDAO.deleteRole(role);
    }

    @Transactional(readOnly = true)
    @Override
    public Role getRoleByRole(String role) {
        return roleDAO.getRoleByRole(role);
    }
}
