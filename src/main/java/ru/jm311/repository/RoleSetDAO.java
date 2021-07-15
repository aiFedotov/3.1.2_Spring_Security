package ru.jm311.repository;

import org.springframework.stereotype.Repository;
import ru.jm311.entity.Role;
import java.util.Set;

@Repository
public interface RoleSetDAO {

    public Set<Role> getRolesByName(String[] roles);
}
