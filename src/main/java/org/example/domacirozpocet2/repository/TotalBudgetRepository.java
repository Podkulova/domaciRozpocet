package org.example.domacirozpocet2.repository;

import org.example.domacirozpocet2.entity.TotalBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalBudgetRepository extends JpaRepository<TotalBudget, Long> {
}
