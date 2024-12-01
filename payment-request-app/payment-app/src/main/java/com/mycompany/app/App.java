package com.mycompany.app;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        // Create a sample PaymentRequest object
        PaymentRequest request = new PaymentRequest("John Doe", "Jane Smith", 150.75, "2024-12-01");

        // Create a JsonWriter object to write the PaymentRequest to a file
        JsonWriter writer = new JsonWriter();

        try {
            System.out.println("Writing PaymentRequest object to JSON...");
            writer.writeToJson(request);
            System.out.println("JSON file created: paymentRequest.json");

            System.out.println("\nReading JSON file and deserializing...");
            JsonReader reader = new JsonReader();
            PaymentRequest readRequest = reader.readFromJson();

            // Print the deserialized object details to the terminal
            System.out.println("\n--- Payment Request Details ---");
            System.out.println("Payer Name: " + readRequest.getPayerName());
            System.out.println("Payee Name: " + readRequest.getPayeeName());
            System.out.println("Amount: $" + readRequest.getAmount());
            System.out.println("Payment Date: " + readRequest.getPaymentDate());
            System.out.println("--------------------------------");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
