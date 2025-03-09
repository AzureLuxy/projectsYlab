package usecases;

import domain.Transaction;
import domain.User;
import infrastructure.input.Input;
import infrastructure.output.Output;

import java.util.List;

public class TransactionImp implements TransactionService {

    @Override
    public boolean addTransaction(Input input, Output output) {
        return false;
    }

    @Override
    public boolean setBudget(Input input, Output output) {
        output.println("Введите сумму месячного бюджета: ");
        double budget = input.readDouble();
        if (budget != 0.0) {
            User.getCurrentUser().setMonthlybudget(budget);
            output.println("Месячный бюджет установлен! Он составляет " + User.getCurrentUser().getMonthlybudget());
            return true;
        }
        output.println("Возврат на предыдущее меню");
        return false;
    }

    @Override
    public List<Transaction> getListTrn(Input input, Output output) {
        return List.of();
    }
}
