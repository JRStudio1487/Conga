package es.jrstudio.conga.repositories;

import es.jrstudio.conga.model.Expense;
import es.jrstudio.conga.model.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    boolean existsById(Long id);
    Optional<Expense> findByType(ExpenseType type);
    boolean existsByType(ExpenseType type);
    Optional<Expense> findByDate(LocalDate date);
    boolean existsByDate(LocalDate date);
}
