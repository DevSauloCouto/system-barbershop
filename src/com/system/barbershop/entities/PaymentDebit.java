package com.system.barbershop.entities;

import com.system.barbershop.entities.abstracts.Payment;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentDebit extends Payment {

    private Long numberCard;
    private Double balance;

    public PaymentDebit() {}

    public PaymentDebit(Double valuePay, Client client, Long numberCard, Double balance) {
        super(valuePay, client);
        this.numberCard = numberCard;
        this.balance = balance;
    }
    @Override
    public Boolean pay() {
        if (valuePay > balance) {
            return false;
        }
        this.datePayment = LocalDateTime.now();
        return true;
    }

}
