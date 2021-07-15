package ru.jm311.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jm311.entity.Role;
import ru.jm311.entity.User;
import ru.jm311.repository.RoleRepository;
import ru.jm311.repository.RoleSetDAO;
import ru.jm311.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserService {

    final private UserRepository userRepository;
    final private RoleRepository roleRepository;
    final private RoleSetDAO roleSetDAO;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, RoleSetDAO roleSetDAO) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.roleSetDAO = roleSetDAO;
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    public Set<Role> getRolesByName(String[] roles) {
        return roleSetDAO.getRolesByName(roles);
    }

    public User getUser(Long id) {
        Optional<User> userFromDb = userRepository.findById(id);
        return userFromDb.orElse(new User());
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void editUser(Long id, User user) {
        userRepository.save(user);
    }
}
