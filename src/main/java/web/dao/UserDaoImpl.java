package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        Query query = entityManager.createQuery("select distinct u from User u join fetch u.roles");
        return query.getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager
                .createQuery("from User u join fetch u.roles where u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public User getUserByLogin(String login) {
        return entityManager
                .createQuery("from User u join fetch u.roles where u.login = :login", User.class)
                .setParameter("login", login)
                .getSingleResult();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }
}

