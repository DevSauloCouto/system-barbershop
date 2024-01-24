package com.system.barbershop.entities;

import com.system.barbershop.entities.abstracts.Payment;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentPix extends Payment {

    private Long numberAccount;

    public PaymentPix() {}

    public PaymentPix(Double valuePay, Client payer, Long numberAccount) {
        super(valuePay, payer);
        this.numberAccount = numberAccount;
    }

    public void generateCodeToPay() {
        UUID keyAleatory = UUID.randomUUID();
        System.out.println("Chave aleatória: " + keyAleatory);
    }
    @Override
    public Boolean pay() {
        this.datePayment = LocalDateTime.now();
        return true;
    }

    @Override
    public String toString() {
        return "Valor: "
                + String.format("%.2f", valuePay)
                + "\nInformações de pagamento: "
                + "\nNome: "
                + payer.getName()
                + "\nEmail: "
                + payer.getEmail()
                + "\nNúmero da conta: "
                + numberAccount;
    }

}
