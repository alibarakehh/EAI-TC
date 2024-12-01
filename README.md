

# Payment Request System - README - Ali El Rida Barakeh (210117)

This project provides a simple console application that allows users to input payment request details, store them in a JSON file, and view the saved data. The application uses Jackson for JSON serialization and deserialization.

## Features

- **Add Payment Requests**: Users can input payment request details including payer name, payee name, amount, and payment date.
- **Store Data in JSON**: Payment requests are saved in a JSON file (`paymentRequests.json`) for persistence.
- **Load Existing Data**: The application loads any existing payment requests from the JSON file when started.
- **Display Payment Requests**: At the end of the session, all stored payment requests are displayed.

## Components

The application consists of the following classes:

1. **PaymentRequest**: This class represents a payment request and contains details like the payer name, payee name, amount, and payment date.
   
   - Properties:
     - `payerName` (String): The name of the payer.
     - `payeeName` (String): The name of the payee.
     - `amount` (double): The payment amount.
     - `paymentDate` (String): The date of the payment in `yyyy-mm-dd` format.
   
   - Methods:
     - Getters and setters for each property.
     - A `toString` method that returns a human-readable string for the payment request.

2. **JsonWriter**: This class handles writing payment request data to a JSON file.

   - Methods:
     - `writeToJson(List<PaymentRequest> paymentRequests)`: This method writes the list of payment requests to the `paymentRequests.json` file.

3. **JsonReader**: This class is responsible for reading payment request data from the JSON file.

   - Methods:
     - `readFromJson()`: Reads the list of payment requests from the `paymentRequests.json` file. If the file doesn't exist, it returns an empty list.

4. **App**: This is the main class that controls the flow of the application.

   - Flow:
     1. Reads existing payment requests from the JSON file using `JsonReader`.
     2. Allows the user to input payment request details (payer name, payee name, amount, payment date).
     3. Adds the new payment request to the list and saves the updated list to the JSON file using `JsonWriter`.
     4. Displays all stored payment requests when the user decides to exit.

## Prerequisites

- Java 8 or higher.
- Jackson library for JSON processing (version 2.x).

### Dependencies

The project uses Jackson for JSON parsing. Ensure the following libraries are included in your project:

- **Jackson Databind**:
   - Maven: `com.fasterxml.jackson.core:jackson-databind:2.13.3` (or the latest version).
   
   - Gradle:
     ```gradle
     implementation 'com.fasterxml.jackson.core:jackson-databind:2.13.3'
     ```

## How to Use

### 1. Clone the Repository

```bash
git clone <repository_url>
cd <project_directory>
```

### 2. Build and Run the Application

- If using Maven:

```bash
mvn clean package
java -jar target/<your_jar_file>.jar
```

- If using Gradle:

```bash
gradle build
java -jar build/libs/<your_jar_file>.jar
```

### 3. Adding Payment Requests

- The application will prompt the user to input payment request details one by one:
  - **Payer Name**: The person or entity making the payment.
  - **Payee Name**: The person or entity receiving the payment.
  - **Amount**: The amount of the payment.
  - **Payment Date**: The date when the payment is made (in `yyyy-mm-dd` format).
  
- After each entry, you will be asked if you wish to add another request. Type `yes` to continue or `no` to finish.

### 4. Viewing the Final List

- Once you choose to stop entering payment requests, the application will display all the payment requests saved in the JSON file.

### 5. File Storage

- The data will be saved in a file named `paymentRequests.json` in the project's root directory.
  - Example format:
  ```json
  [
      {
          "payerName": "Ali Barakeh",
          "payeeName": "Michael Johnson",
          "amount": 100.50,
          "paymentDate": "2024-12-01"
      },
      {
          "payerName": "Sarah Lee",
          "payeeName": "Ali Barakeh",
          "amount": 200.75,
          "paymentDate": "2024-12-02"
      }
  ]
  ```

## Example Output

```
Enter Payment Request Details:
Payer Name: Ali Barakeh
Payee Name: Michael Johnson
Amount: 100.50
Payment Date (yyyy-mm-dd): 2024-12-01

Payment request added successfully.

Do you want to add another request? (yes/no): yes

Enter Payment Request Details:
Payer Name: Sarah Lee
Payee Name: Ali Barakeh
Amount: 200.75
Payment Date (yyyy-mm-dd): 2024-12-02

Payment request added successfully.

Do you want to add another request? (yes/no): no

--- Final List of Payment Requests ---
Payer Name: Ali Barakeh, Payee Name: Michael Johnson, Amount: $100.5, Payment Date: 2024-12-01
Payer Name: Sarah Lee, Payee Name: Ali Barakeh, Amount: $200.75, Payment Date: 2024-12-02
--------------------------------------
```

## Error Handling

- If there is any issue reading or writing to the file (e.g., file permission issues), an error message will be displayed.
- If the user enters invalid data (e.g., non-numeric values for the payment amount), the application will throw an error.

## Future Enhancements

- **Data Validation**: Add more validation for input data such as ensuring valid date formats and positive amounts.
- **User Interface**: Implement a graphical user interface (GUI) for easier interaction.
- **Search Functionality**: Implement search options to find payment requests by payer name or payment date.
  
## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

