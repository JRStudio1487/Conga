package es.jrstudio.conga.repositories;

import es.jrstudio.conga.model.Expense;
import es.jrstudio.conga.model.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByType(ExpenseType type);
    List<Expense> findbyDate(LocalDate date);
}
