package org.example.domacirozpocet2.service.implementaion;

import lombok.RequiredArgsConstructor;
import org.example.domacirozpocet2.dto.UserRequest;
import org.example.domacirozpocet2.entity.Role;
import org.example.domacirozpocet2.entity.User;
import org.example.domacirozpocet2.exception.UsersNotFoundExeption;
import org.example.domacirozpocet2.repository.RoleRepository;
import org.example.domacirozpocet2.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository repository;

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public User saveUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getMobile())
                .mobile(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .build();
        /*return repository.save(user);

        public void saveUser (UserRequest UserRequest){
            User user = new User();
            user.setName(UserRequest.getName());
            user.setEmail(UserRequest.getEmail());*/
        //encrypt the password using spring security

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null) {
            role = checkRoleExist();
        }
        user.setRoles(List.of(role));
        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUser(Long id) throws UsersNotFoundExeption {
        User user = repository.findByUserId(id);
        if (user != null) {
            return user;
        } else {
            throw new UsersNotFoundExeption("user nenalezen s id: " + id);
        }
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }


    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public List<UserRequest> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private UserRequest convertEntityToDto(User user) {
        UserRequest UserRequest = new UserRequest();
        UserRequest.setName(user.getName());
        UserRequest.setEmail(user.getEmail());
        return UserRequest;
    }
}

