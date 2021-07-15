package ru.jm311.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jm311.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
