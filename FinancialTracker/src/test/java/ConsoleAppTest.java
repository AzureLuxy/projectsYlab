import infrastructure.ConsoleApp;
import infrastructure.input.Input;
import infrastructure.input.Menu;
import infrastructure.output.Output;
import infrastructure.data.DataStorage;

import org.junit.jupiter.api.*;
import usecases.AuthService;
import usecases.TransactionService;

import static org.mockito.Mockito.*;

    class ConsoleAppTest {
        private ConsoleApp app;
        private Input inputMock;
        private Output outputMock;
        private DataStorage dataMock;
        private AuthService authMock;
        private TransactionService tnsMock;

        @BeforeEach
        void setUp() {
            inputMock = mock(Input.class);
            outputMock = mock(Output.class);
            dataMock = mock(DataStorage.class);
            authMock = mock(AuthService.class);
            tnsMock = mock(TransactionService.class);

            app = new ConsoleApp(inputMock, outputMock, dataMock, authMock, tnsMock);
        }

        @Test
        void testRegister() {
            // Arrange
            when(inputMock.read())
                    .thenReturn("2")
                    .thenReturn("testUser")
                    .thenReturn("testPass");

            when(authMock.register(any(Input.class), any(Output.class), eq(dataMock))).thenReturn(true);

            // Act
            Menu.MenuState result = app.loginMenu();

            // Assert
            verify(outputMock).println("Регистрация успешна! Произведите вход в систему.");
            verify(authMock).register(inputMock, outputMock, dataMock);
        }

    }
