package usecases;

import domain.Transaction;
import infrastructure.input.Input;
import infrastructure.output.Output;

import java.util.List;

public interface TransactionService {
    boolean addTransaction(Input input, Output output);
    boolean setBudget(Input input, Output output);
    List<Transaction> getListTrn(Input input, Output output);
}
