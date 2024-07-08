package org.example.domacirozpocet2.repository;

import org.example.domacirozpocet2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long id);
    User findByName(String name);
    User findByEmail(String email);
}
