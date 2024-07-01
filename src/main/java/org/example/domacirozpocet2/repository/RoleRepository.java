package org.example.domacirozpocet2.repository;

import org.example.domacirozpocet2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {
    Role findByName(String name);

}
