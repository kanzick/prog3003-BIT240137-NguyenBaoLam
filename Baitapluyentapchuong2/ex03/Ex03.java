package com.mycompany.ex03;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Ex03 {

    static CompletableFuture<String> validateCustomer(String customerName) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("[" + Thread.currentThread().getName() + "] Validating customer: " + customerName + "...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            String result = "Validation successful: " + customerName;
            System.out.println("[" + Thread.currentThread().getName() + "] Done - " + result);
            return result;
        });
    }

    static CompletableFuture<String> generateTicket(String movieTitle) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("[" + Thread.currentThread().getName() + "] Generating ticket for: " + movieTitle + "...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            String result = "Ticket issued - Movie: " + movieTitle + " | Seat: A12";
            System.out.println("[" + Thread.currentThread().getName() + "] Done - " + result);
            return result;
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("=== Movie Ticket Booking System ===\n");

        CompletableFuture<String> validateFuture = validateCustomer("John Smith");
        CompletableFuture<String> ticketFuture = generateTicket("Avengers: Endgame");

        CompletableFuture<String> combinedFuture = validateFuture.thenCombine(
                ticketFuture,
                (validateResult, ticketResult)
                -> "\n=== Booking Complete ===\n"
                + "  - " + validateResult + "\n"
                + "  - " + ticketResult
        );

        System.out.println(combinedFuture.get());
    }
}
