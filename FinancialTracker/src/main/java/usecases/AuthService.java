package usecases;

import infrastructure.data.DataStorage;
import infrastructure.input.Input;
import infrastructure.output.Output;

public interface AuthService {
    boolean login(Input input, Output output, DataStorage data);
    boolean register(Input input, Output output, DataStorage data);
}

