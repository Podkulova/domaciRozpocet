package org.example.domacirozpocet2.repository;

import org.example.domacirozpocet2.model.BudgetSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetSummaryRepository extends JpaRepository<BudgetSummary, Long> {
}
