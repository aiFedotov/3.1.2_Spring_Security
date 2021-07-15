package ru.jm311.repository;

import org.springframework.stereotype.Repository;
import ru.jm311.entity.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

@Repository
public class RoleSetDAOImpl implements RoleSetDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> getRolesByName(String[] roles) {

        Set<Role> roleResult = new HashSet<>();

        for (String role : roles) {
            TypedQuery<Role> query = entityManager.createQuery("select role from Role role where role.role = :role", Role.class);
            query.setParameter("role", role);
            Role result = query.getSingleResult();
            roleResult.add(result);
        }
        return roleResult;
    }
}
