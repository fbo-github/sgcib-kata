package fr.fbo.kata;

import fr.fbo.kata.exception.NSFException;
import fr.fbo.kata.exception.OverdraftException;
import fr.fbo.kata.model.Account;
import fr.fbo.kata.service.AccountService;
import fr.fbo.kata.service.TransactionService;
import fr.fbo.kata.service.impl.AccountServiceImpl;
import fr.fbo.kata.service.impl.TransactionServiceImpl;
import fr.fbo.kata.util.AccountBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    private static final int MAX_OPTION = 4;

    public static void main(String[] args) {

        Account account = new AccountBuilder(1L, BigDecimal.valueOf(0), new ArrayList<>()).build();
        AccountService accountService = new AccountServiceImpl();

        String[] options = {"1- Make a deposit ", "2- Make a withdrawal ", "3- Show history ", "4- Exit"};
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != MAX_OPTION) {
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        deposit(scanner, account, accountService);
                        break;
                    case 2:
                        withdraw(scanner, account, accountService);
                        break;
                    case 3:
                        showHistory(account);
                        break;
                    case 4:
                        exit(0);
                }
            } catch (NSFException | OverdraftException ex) {
                System.out.println(ex.getMessage());
                printMenu(options);
                scanner.next();
            } catch (Exception ex) {
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Please enter the digit corresponding to your option : ");
    }

    private static void deposit(Scanner scanner, Account account, AccountService accountService) {
        System.out.print("Deposit amount : ");
        // read the deposit amount
        int amount = scanner.nextInt();
        accountService.deposit(account, BigDecimal.valueOf(amount));
        System.out.println("Deposit done");
        displayThanks();
    }

    private static void withdraw(Scanner scanner, Account account, AccountService accountService) {
        System.out.print("Withdraw amount : ");
        // read the withdraw amount
        int amount = scanner.nextInt();
        accountService.pull(account, BigDecimal.valueOf(amount));
        System.out.println("Withdraw done");
        displayThanks();
    }

    private static void showHistory(Account account) {
        TransactionService operationService = new TransactionServiceImpl();
        operationService.getHistory(account).forEach(transaction -> System.out.println(transaction.toString()));
        displayThanks();
    }

    private static void displayThanks() {
        System.out.println("Thank you for using our service, something else to do ?\n");
    }
}
