package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> listRole() {
        Query query = entityManager.createQuery("SELECT DISTINCT r FROM Role r JOIN FETCH r.users");
        return query.getResultList();
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void deleteRole(Role role) {
        entityManager.remove(role);
    }

    @Override
    public Role getRoleByRole(String role) {
        return entityManager.createQuery("FROM Role r JOIN FETCH r.users WHERE r.role =:role", Role.class)
                .setParameter("role", role).getSingleResult();
    }
}
