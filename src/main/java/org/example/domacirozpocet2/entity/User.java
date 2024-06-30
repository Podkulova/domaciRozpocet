package org.example.domacirozpocet2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String mobile;
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"), // Toto by mělo být jméno sloupce v tabulce users_roles, který odkazuje na ID uživatele
            inverseJoinColumns = @JoinColumn(name = "role_id") // Toto by mělo být jméno sloupce v tabulce users_roles, který odkazuje na ID role
    )
    private List<Role> roles = new ArrayList<>();
}
