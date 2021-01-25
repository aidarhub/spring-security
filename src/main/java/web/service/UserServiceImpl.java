package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        System.out.println("in addUser UserServiceImp");
        System.out.println("user= " + user);
        Role role = roleService.getRoleByRole("ROLE_USER");
        System.out.println("role =" + role);
        user.addRole(role);
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User user) {
        System.out.println("id = " + id);
        System.out.println("user " + user);
        user.setId(id);
        Role role = roleService.getRoleByRole("ROLE_USER");
        user.addRole(role);
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = userDao.getUserById(id);
        userDao.deleteUser(user);
    }

    @Transactional
    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }
}
