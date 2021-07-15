package ru.jm311.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jm311.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
