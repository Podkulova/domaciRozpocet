package org.example.domacirozpocet2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domacirozpocet2.dto.BudgerRecord;
import org.example.domacirozpocet2.entity.BudgetItem;
import org.example.domacirozpocet2.service.implementaion.BudgetServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class RestController {

    private final BudgetServiceImpl budgetService;

    @PostMapping("/createBudget")
    public ResponseEntity<String> createBudget(@RequestBody BudgerRecord budgetRecord) {
        budgetService.createBudget(budgetRecord.name(), budgetRecord.amount(), budgetRecord.category(), budgetRecord.date());
        return new ResponseEntity<>(String.format("Blahopřeji, budget s názvem %s byl uložen", budgetRecord.name()), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBudget")
    public ResponseEntity<String> deleteBudget(@RequestParam Integer toDoId) {
        budgetService.deleteBudget(toDoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<BudgetItem>> allBudget() {
        return new ResponseEntity<>(budgetService.getAllBudgetItems(), HttpStatus.OK);
    }
}
