package org.example.domacirozpocet2.service.implementaion;

import lombok.Data;
import lombok.Setter;
import org.example.domacirozpocet2.model.TotalBudget;
import org.example.domacirozpocet2.repository.TotalBudgetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class TotalBudgetService {

    private double totalBudgetPerson1;
    private double totalBudgetPerson2;

    // Konstruktor s počátečními hodnotami
    public TotalBudgetService() {
        this.totalBudgetPerson1 = 0.0;
        this.totalBudgetPerson2 = 0.0;
    }

    public TotalBudgetService(double totalBudgetPerson1, double totalBudgetPerson2) {
        this.totalBudgetPerson1 = totalBudgetPerson1;
        this.totalBudgetPerson2 = totalBudgetPerson2;
    }


    public double getTotalBudgetPerson1() {
        return totalBudgetPerson1;
    }

    public double getTotalBudgetPerson2() {
        return totalBudgetPerson2;
    }

    public void updateTotalBudget(double totalBudgetPerson1, double totalBudgetPerson2) {
        this.totalBudgetPerson1 = totalBudgetPerson1;
        this.totalBudgetPerson2 = totalBudgetPerson2;
    }

    public double getTotalBudgetForTwoUsers() {
        return totalBudgetPerson1 + totalBudgetPerson2;
    }
}
