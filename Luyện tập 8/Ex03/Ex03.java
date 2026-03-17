package com.ex03;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Ex03 {

    public static CompletableFuture<Boolean> authenticateCustomer(String customerId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2); // simulate delay
                if (customerId.equals("12345")) {
                    System.out.println("Customer authenticated successfully.");
                    return true;
                } else {
                    throw new RuntimeException("Authentication failed!");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Authentication interrupted!");
            }
        });
    }

    public static CompletableFuture<Boolean> checkBalance(double balance, double amount) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                if (balance >= amount) {
                    System.out.println("Balance check passed.");
                    return true;
                } else {
                    throw new RuntimeException("Insufficient balance!");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Balance check interrupted!");
            }
        });
    }

    public static CompletableFuture<Void> performTransaction(double amount) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1); // simulate delay
                System.out.println("Transaction of $" + amount + " completed successfully.");
            } catch (InterruptedException e) {
                throw new RuntimeException("Transaction interrupted!");
            }
        });
    }

    public static void main(String[] args) {
        String customerId = "12345";
        double balance = 500.0;
        double amount = 200.0;

        authenticateCustomer(customerId)
                .thenCompose(authenticated -> {
                    if (authenticated) {
                        return checkBalance(balance, amount);
                    } else {
                        throw new RuntimeException("Authentication failed, transaction cancelled.");
                    }
                })
                .thenCompose(balanceOk -> {
                    if (balanceOk) {
                        return performTransaction(amount);
                    } else {
                        throw new RuntimeException("Balance check failed, transaction cancelled.");
                    }
                })
                .exceptionally(ex -> {
                    System.out.println("Error: " + ex.getMessage());
                    return null;
                })
                .join();
    }
}
