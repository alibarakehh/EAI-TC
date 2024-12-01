package com.mycompany.app;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JsonWriter writer = new JsonWriter();
        JsonReader reader = new JsonReader();
 
        try {
            // Load existing payment requests from the file
            List<PaymentRequest> paymentRequests = reader.readFromJson();
 
            while (true) {
                System.out.println("Enter Payment Request Details:");
                System.out.print("Payer Name: ");
                String payerName = scanner.nextLine();
 
                System.out.print("Payee Name: ");
                String payeeName = scanner.nextLine();
 
                System.out.print("Amount: ");
                double amount = Double.parseDouble(scanner.nextLine());
 
                System.out.print("Payment Date (yyyy-mm-dd): ");
                String paymentDate = scanner.nextLine();
 
                // Create a new PaymentRequest object and add it to the list
                PaymentRequest newRequest = new PaymentRequest(payerName, payeeName, amount, paymentDate);
                paymentRequests.add(newRequest);
 
                // Write the updated list to the JSON file
                writer.writeToJson(paymentRequests);
 
                System.out.println("\nPayment request added successfully.");
 
                System.out.print("\nDo you want to add another request? (yes/no): ");
                String continueInput = scanner.nextLine();
                if (!continueInput.equalsIgnoreCase("yes")) {
                    break;
                }
            }
 
            // Final display of all payment requests
            System.out.println("\n--- Final List of Payment Requests ---");
            for (PaymentRequest request : paymentRequests) {
                System.out.println(request);
            }
            System.out.println("--------------------------------------");
 
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
 
        scanner.close();
    }
}
 