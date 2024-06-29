package org.example.domacirozpocet2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BudgetSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalBudget;
    private double totalSpent;
    private double remainingBudget;

    public BudgetSummary(double totalBudget, double totalSpent, double remainingBudget) {
        this.totalBudget = totalBudget;
        this.totalSpent = totalSpent;
        this.remainingBudget = remainingBudget;
    }

    public double getRemainingBudget() {
        return totalBudget - totalSpent;
    }
}
