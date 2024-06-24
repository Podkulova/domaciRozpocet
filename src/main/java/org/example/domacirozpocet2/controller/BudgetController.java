package org.example.domacirozpocet2.controller;

import org.example.domacirozpocet2.model.BudgetItem;
import org.example.domacirozpocet2.model.BudgetSummary;
import org.example.domacirozpocet2.repository.BudgetSummaryRepository;
import org.example.domacirozpocet2.service.implementaion.BudgetServiceImpl;
import org.example.domacirozpocet2.service.implementaion.BudgetSummaryService;
import org.example.domacirozpocet2.service.implementaion.TotalBudgetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class BudgetController {

    private final BudgetServiceImpl budgetService;
    private final BudgetSummaryService budgetSummaryService;
    private final TotalBudgetService totalBudgetService;

    private double totalBudget = 0.0;

    public BudgetController(BudgetServiceImpl budgetService, BudgetSummaryService budgetSummaryService, TotalBudgetService totalBudgetService) {
        this.budgetService = budgetService;
        this.budgetSummaryService = budgetSummaryService;
        this.totalBudgetService = totalBudgetService;
    }

    @PostMapping("/createBudget")
    public String createBudget(@RequestParam String name, @RequestParam double amount, @RequestParam String category, @RequestParam LocalDate date, Model model) {
        BudgetItem budgetItem = new BudgetItem(name, amount, category, date);
        budgetService.addBudgetItem(budgetItem);
        budgetService.addBudgetItem2(budgetItem);
        return "redirect:/";
    }

    @GetMapping
    public String allBadget(Model model) {
        model.addAttribute("budgets", budgetService.getAllBudgetItems());
        model.addAttribute("totalBudget", totalBudget);
        model.addAttribute("totalSpent", budgetService.getTotalSpent());
        model.addAttribute("remainingBudget", budgetService.getRemainingBudget(totalBudget));
        return "index";
    }

    @PostMapping("/setTotalBudget")
    public String setTotalBudget(@RequestParam double totalBudget) {
        this.totalBudget = totalBudget;
        return "redirect:/";
    }

    @PostMapping("/deleteBudget")
    public String deleteToDo(@RequestParam Integer budgetId) {
        budgetService.deleteBudget(budgetId);
        return "redirect:/";
    }

    @PostMapping("/addExpense")
    public String addExpense(@RequestParam double amount) {
        budgetService.addExpense(amount);
        budgetSummaryService.updateBudget(budgetSummaryService.getBudgetSummary().getTotalBudget(), budgetService.getTotalSpent());
        return "redirect:/";
    }

    @GetMapping("/summary")
    public String showSummary(Model model) {
        model.addAttribute("totalBudget", budgetSummaryService.getBudgetSummary().getTotalBudget());
        model.addAttribute("totalBudgetPerson1", totalBudgetService.getTotalBudgetPerson1());
        model.addAttribute("totalBudgetPerson", totalBudgetService.getTotalBudgetPerson1());
        return "index";
    }

    @PostMapping("/setTotalBudgetForTwo")
    public String setTotalBudgetForTwo(@RequestParam double totalBudgetPerson1, @RequestParam double totalBudgetPerson2) {
        totalBudgetService.updateTotalBudget(totalBudgetPerson1, totalBudgetPerson2);
        return "redirect:/";
    }


    @GetMapping("/totalBudget")
    public String showTotalBudget(Model model) {
        model.addAttribute("totalBudgetPerson1", totalBudgetService.getTotalBudgetPerson1());
        model.addAttribute("totalBudgetPerson2", totalBudgetService.getTotalBudgetPerson2());
        return "totalBudget";
    }

}

