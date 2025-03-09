package domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static User currentUser;
    String email;
    String password;
    String name;
    double monthlybudget;
    List<Transaction> transactions;
    Goal savingsGoal;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        User.currentUser = currentUser;
    }

    public double getMonthlybudget() {
        return monthlybudget;
    }

    public void setMonthlybudget(double monthlybudget) {
        this.monthlybudget = monthlybudget;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Goal getSavingsGoal() {
        return savingsGoal;
    }

    public void setSavingsGoal(Goal savingsGoal) {
        this.savingsGoal = savingsGoal;
    }
}
