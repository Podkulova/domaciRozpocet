package org.example.domacirozpocet2.service.implementaion;

import org.example.domacirozpocet2.entity.BudgetSummary;
import org.example.domacirozpocet2.repository.BudgetSummaryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BudgetSummaryService {
    private BudgetSummaryRepository budgetSummaryRepository;

    public BudgetSummaryService(BudgetSummaryRepository budgetSummaryRepository) {
        this.budgetSummaryRepository = budgetSummaryRepository;
    }
    public BudgetSummary getBudgetSummary() {
        Optional<BudgetSummary> optionalBudgetSummary = budgetSummaryRepository.findById(1L);
        return optionalBudgetSummary.orElseGet(() -> {
            BudgetSummary newBudgetSummary = new BudgetSummary();
            newBudgetSummary.setTotalBudget(0.0);
            newBudgetSummary.setTotalSpent(0.0);
            return newBudgetSummary;
        });
    }

    public void saveBudgetSummary(BudgetSummary budgetSummary) {
        budgetSummaryRepository.save(budgetSummary);
    }

    public void updateBudget(double totalBudget, double totalSpent) {
        BudgetSummary budgetSummary = getBudgetSummary();
        budgetSummary.setTotalBudget(totalBudget);
        budgetSummary.setTotalSpent(totalSpent);
        budgetSummary.setRemainingBudget(totalBudget - totalSpent);
        saveBudgetSummary(budgetSummary);
    }
}
