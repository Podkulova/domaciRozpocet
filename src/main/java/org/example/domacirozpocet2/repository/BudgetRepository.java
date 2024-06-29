package org.example.domacirozpocet2.repository;

import org.example.domacirozpocet2.entity.BudgetItem;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<BudgetItem, Integer>{
}
