package es.jrstudio.conga.services;

import es.jrstudio.conga.model.Expense;
import es.jrstudio.conga.model.ExpenseType;
import es.jrstudio.conga.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    public List<Expense> expenseList() {
        return expenseRepository.findAll();
    }
    public Optional<Expense> getOne(Long id) {
        return expenseRepository.findById(id);
    }
    public Optional<Expense> getByType(ExpenseType type) {
        return expenseRepository.findByType((type));
    }
    public Optional<Expense> getByDate(LocalDate date) {
        return expenseRepository.findByDate(date);
    }

    public void save(Expense expense) {
        expenseRepository.save(expense);
    }
    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }
    public boolean existsById(Long id) {
        return expenseRepository.existsById(id);
    }
    public boolean existsByType(ExpenseType type) {
        return expenseRepository.existsByType(type);
    }
    public boolean existsByDate(LocalDate date) {
        return expenseRepository.existsByDate(date);
    }
}
