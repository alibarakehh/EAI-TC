package com.mycompany.app;

public class PaymentRequest {
    private String payerName;
    private String payeeName;
    private double amount;
    private String paymentDate;

    public PaymentRequest() {}

    public PaymentRequest(String payerName, String payeeName, double amount, String paymentDate) {
        this.payerName = payerName;
        this.payeeName = payeeName;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public String getPayerName() { return payerName; }
    public void setPayerName(String payerName) { this.payerName = payerName; }

    public String getPayeeName() { return payeeName; }
    public void setPayeeName(String payeeName) { this.payeeName = payeeName; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentDate() { return paymentDate; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }
}
