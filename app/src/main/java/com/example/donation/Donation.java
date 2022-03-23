package com.example.donation;

public class Donation {
    public int id;
    private int amount;
    private String method;

    public Donation(int amount, String method) {
        this.amount = amount;
        this.method = method;
    }

    public Donation() {
        this.amount = 0;
        this.method = "";
    }

    public int getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String toString() {
        return this.id + ", " + this.amount + ", " + this.method;
    }

}
