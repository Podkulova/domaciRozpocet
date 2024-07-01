package org.example.domacirozpocet2.service.implementaion;

import jakarta.transaction.Transactional;
import org.example.domacirozpocet2.entity.Role;
import org.example.domacirozpocet2.repository.RoleRepository;
import org.example.domacirozpocet2.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.domacirozpocet2.dto.UserRequest;
import org.example.domacirozpocet2.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Test
    public void testSaveUser() {
        // Vytvoření userRequest s platným heslem
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("test@test.cz");
        userRequest.setName("Test User");
        userRequest.setMobile("1236567890");
        userRequest.setPassword("password123");

    }
}