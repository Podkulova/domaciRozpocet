package org.example.domacirozpocet2.service;

import org.example.domacirozpocet2.entity.BudgetItem;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface BudgetService {
    void createBudget(String name, double amount, String category, LocalDate date);
    void addBudgetItem(BudgetItem budgetItem);
    void addBudgetItem2(BudgetItem budgetItem);
    List<BudgetItem> getAllBudgetItems();
    double getTotalSpent();
    void deleteBudget(Integer id);
    void addExpense(double amount);
}
