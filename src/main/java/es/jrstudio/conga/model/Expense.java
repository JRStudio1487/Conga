package es.jrstudio.conga.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private Double amount;
    @JsonFormat(pattern = "dd/MM/YYYY")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private ExpenseType type;

    // CONSTRUCTORS
    public Expense() {
    }
    public Expense(String category, Double amount, LocalDate date, ExpenseType type) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    // GETTERS
    public Long getId() {
        return id;
    }
    public String getCategory() {
        return category;
    }
    public Double getAmount() {
        return amount;
    }
    public LocalDate getDate() {
        return date;
    }
    public ExpenseType getType() {
        return type;
    }
    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setType(ExpenseType type) {
        this.type = type;
    }

}
