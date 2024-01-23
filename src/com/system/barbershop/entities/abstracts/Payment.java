package com.system.barbershop.entities.abstracts;

import com.system.barbershop.entities.Client;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Payment {

    protected UUID id;
    protected Double valuePay;
    protected Client payer;
    protected LocalDateTime datePayment;

    public Payment() {}

    public Payment(Double valuePay, Client payer) {
        this.id = UUID.randomUUID();
        this.valuePay = valuePay;
        this.payer = payer;
    }

    public UUID getId() {
        return id;
    }

    public Double getValuePay() {
        return valuePay;
    }

    public Client getIdPayer() {
        return payer;
    }

    public LocalDateTime getDatePayment() {
        return datePayment;
    }

    public abstract Boolean pay();

    @Override
    public String toString() {
        return "value="
                + valuePay
                + " payer="
                + payer;
    }
}
