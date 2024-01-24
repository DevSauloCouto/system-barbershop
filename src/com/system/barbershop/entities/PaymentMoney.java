package com.system.barbershop.entities;

import com.system.barbershop.entities.abstracts.Payment;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentMoney extends Payment {

    public PaymentMoney() {}

    public PaymentMoney(Double valuePay, Client client) {
        super(valuePay, client);
    }

    public Boolean pay() {
        this.datePayment = LocalDateTime.now();
        return true;
    }

}
