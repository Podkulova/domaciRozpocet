package org.example.domacirozpocet2.service.implementaion;

import org.example.domacirozpocet2.entity.BudgetItem;
import org.example.domacirozpocet2.repository.BudgetRepository;
import org.example.domacirozpocet2.service.BudgetService;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;
    private final BudgetSummaryService budgetSummaryService;

    private List<BudgetItem> budgetItems = new ArrayList<>();

    public BudgetServiceImpl(BudgetRepository builderRepository, BudgetSummaryService budgetSummaryService) {
        this.budgetRepository = builderRepository;
        this.budgetSummaryService = budgetSummaryService;
    }

    @Override
    public void createBudget(String name, double amount, String category, LocalDate date) {
        BudgetItem item = new BudgetItem(name, amount, category, date);
        budgetRepository.save(item);
    }

    @Override
    public List<BudgetItem> getAllBudgetItems() {
        return budgetItems;
    }

    public double getTotalSpent() {
        List<BudgetItem> allBudgetItems = budgetRepository.findAll();
        return allBudgetItems.stream().mapToDouble(BudgetItem::getAmount).sum();
    }

    @Override
    public void addBudgetItem(BudgetItem budgetItem) {
        budgetItems.add(budgetItem);
    }

    @Override
    public void addBudgetItem2(BudgetItem budgetItem) {
        budgetRepository.save(budgetItem);
    }

    @Override
    public void addExpense(double amount) {
        // Implementace přidání výdaje
        BudgetItem expenseItem = new BudgetItem("Expense", -amount, "Expense", LocalDate.now());
        budgetRepository.save(expenseItem);

        // Aktualizujeme informace o rozpočtu
        double totalSpent = getTotalSpent();
        double totalBudget = budgetSummaryService.getBudgetSummary().getTotalBudget();
        budgetSummaryService.updateBudget(totalBudget, totalSpent);
    }


    public double getRemainingBudget(double totalBudget) {
        double totalSpent = getTotalSpent();
        return totalBudget - totalSpent;
    }

    @Override
    public void deleteBudget(Integer id) {
        budgetRepository.deleteById(id);
    }
}
