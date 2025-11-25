package ie.atu;

import ie.atu.week9.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount();
    }

    @Test
    void constructorInitialisation() {
        account = new BankAccount("ACC12345", "Ethan", 100);
        assertEquals("ACC12345", account.getACCNo());
        assertEquals("Ethan", account.getName());
        assertEquals(100, account.getBalance());
    }

    @Test
    void constructorNegativeInitialisation() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new BankAccount("ACC12345", "Ethan", -100));
        assertEquals("Balance must be greater than 0.", ex.getMessage());
    }

    @Test
    void depositingPositiveAmountIncreasesBalance() {
        account = new BankAccount("ACC12345", "Ethan", 1);
        double initialBalance = account.getBalance();
        double depositAmount = 42340;

        account.deposit(depositAmount);

        assertEquals(initialBalance + depositAmount, account.getBalance(), "Balance should increase by the deposited amount");
    }

    @Test
    void deposit_zeroAmount() {
        BankAccount account = new BankAccount();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> account.depositNegative(0)
        );

        assertEquals("Deposit amount must be greater than zero", ex.getMessage());
    }

    @Test
    void deposit_negativeAmount() {
        BankAccount account = new BankAccount();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> account.depositNegative(-50)
        );

        assertEquals("Deposit amount must be greater than zero", ex.getMessage());
    }
    @Test
    void withdraw_positiveAmount_reducesBalance() {
        // Arrange
        BankAccount account = new BankAccount();
        account.deposit(100);  // initial balance

        // Act
        account.withdraw(40);

        // Assert
        assertEquals(60, account.getBalance());
    }

        @Test
        void withdraw_zeroAmount_throwsException() {
            BankAccount account = new BankAccount();
            account.deposit(100); // ensure sufficient balance

            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> account.withdraw(0)
            );

            assertEquals("Withdrawal amount must be greater than zero", ex.getMessage());
        }

        @Test
        void withdraw_negativeAmount_throwsException() {
            BankAccount account = new BankAccount();
            account.deposit(100);

            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> account.withdraw(-30)
            );

            assertEquals("Withdrawal amount must be greater than zero", ex.getMessage());
        }

        @Test
        void withdraw_moreThanBalance_throwsException() {
            // Arrange
            BankAccount account = new BankAccount();
            account.deposit(100);  // current balance

            // Act + Assert
            IllegalArgumentException ex = assertThrows(
                    IllegalArgumentException.class,
                    () -> account.withdraw(150)
            );

            assertEquals("Insufficient funds", ex.getMessage());
        }
}




