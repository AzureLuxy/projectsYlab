package domain;

import java.time.LocalDate;

public class Transaction {
    private double amount;
    private String category;
    private String description;
    private LocalDate date;
    private boolean isIncome;

    public Transaction(double amount, String category, String description, LocalDate date, boolean isIncome) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
        this.isIncome = isIncome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public void setIncome(boolean income) {
        isIncome = income;
    }
}
