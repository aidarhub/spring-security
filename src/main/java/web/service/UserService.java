package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    User getUserById(Long id);

    void addUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    User getUserByLogin(String login);

//    List<User> getAllUsers();
//
//    User getUserById(Long id);
//
//    void updateUser(User user);
//
//    void deleteUser(Long id);
//
//    User getUserByName(String login);
//
//    Role getRoleByName(String name);
//
//    void addRole(Role role);

}
