package es.jrstudio.conga.model;

import java.time.LocalDate;

public class ExpenseDTO {
    private Long id;
    private String category;
    private Double amount;
    private LocalDate date;
    private ExpenseType type;

    // CONSTRUCTORS
    public ExpenseDTO() {
    }
    public ExpenseDTO(String category, Double amount, LocalDate date, ExpenseType type) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    // GETTERS & SETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public ExpenseType getType() {
        return type;
    }
    public void setType(ExpenseType type) {
        this.type = type;
    }

}
