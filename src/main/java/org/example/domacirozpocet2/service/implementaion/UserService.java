package org.example.domacirozpocet2.service.implementaion;

import lombok.RequiredArgsConstructor;
import org.example.domacirozpocet2.dto.UserRequest;
import org.example.domacirozpocet2.entity.User;
import org.example.domacirozpocet2.exception.UsersNotFoundExeption;
import org.example.domacirozpocet2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository repository;

    public User saveUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getMobile())
                .mobile(userRequest.getEmail())
                .build();
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return  repository.findAll();
    }

    public  User getUser(int id) throws UsersNotFoundExeption {
        User user = repository.findByUserId(id);
        if (user != null) {
            return user;
        } else {
            throw new UsersNotFoundExeption("user nenalezen s id: " + id);
        }
    }
}
