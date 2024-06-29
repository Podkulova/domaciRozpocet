package org.example.domacirozpocet2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class TotalBudget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false)
    private double totalBudgetPerson1;

    @Column(nullable = false)
    private double totalBudgetPerson2;
}
