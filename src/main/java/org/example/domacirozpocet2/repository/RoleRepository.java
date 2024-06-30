package org.example.domacirozpocet2.repository;

import org.example.domacirozpocet2.entity.Role;
import org.example.domacirozpocet2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Integer> {
    Role findByName(String name);

}
