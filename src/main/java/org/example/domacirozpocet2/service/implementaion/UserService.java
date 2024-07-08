package org.example.domacirozpocet2.service.implementaion;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domacirozpocet2.dto.UserRequest;
import org.example.domacirozpocet2.entity.Role;
import org.example.domacirozpocet2.entity.User;
import org.example.domacirozpocet2.exception.UsersNotFoundExeption;
import org.example.domacirozpocet2.repository.RoleRepository;
import org.example.domacirozpocet2.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User saveUser(@Valid UserRequest userRequest) {
        log.info("Saving user with email: {}", userRequest.getEmail());

        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .build();

        log.info("User details: {}", user);

        Role role = roleRepository.findByName("ROLE_USER");
        if (role == null) {
            role = checkRoleExist();
        }

        user.setRoles(Set.of(role));
        role.getUsers().add(user);

       User saveUser = userRepository.save(user);
        log.info("Saved user: {}", saveUser);
        return saveUser;
    }

    private Role checkRoleExist() {
        Role role = Role.builder().name("ROLE_USER").build();

        Role savedRole = roleRepository.findByName("ROLE_USER");
        if (savedRole == null) {
            savedRole = roleRepository.save(role);
        }
        log.info("Saved role: {}", savedRole);
        return savedRole;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) throws UsersNotFoundExeption {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsersNotFoundExeption("User not found with id: " + id));
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserRequest> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertEntityBudget)
                .collect(Collectors.toList());
    }

    private UserRequest convertEntityBudget(User user) {
        UserRequest userRequest = new UserRequest();
        userRequest.setName(user.getName());
        userRequest.setEmail(user.getEmail());
        return userRequest;
    }
}
