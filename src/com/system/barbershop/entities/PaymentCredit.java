package com.system.barbershop.entities;

import com.system.barbershop.entities.abstracts.Payment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class PaymentCredit extends Payment {

    public static DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yy");
    private Long numberCard;
    private String cvvCard;
    private LocalDate dateValidateCard;

    public PaymentCredit() {}

    public PaymentCredit(Double valuePay, Client payer, Long numberCard, String cvvCard, LocalDate dateValidateCard) {
        super(valuePay, payer);
        this.numberCard = numberCard;
        this.cvvCard = cvvCard;
        this.dateValidateCard = dateValidateCard;
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
                + "\nNúmero do cartão: "
                + numberCard;
    }

}
