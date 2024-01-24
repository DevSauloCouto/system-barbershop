package com.system.barbershop.UI;

import com.system.barbershop.entities.PaymentCredit;
import com.system.barbershop.entities.PaymentDebit;
import com.system.barbershop.entities.PaymentMoney;
import com.system.barbershop.entities.PaymentPix;
import com.system.barbershop.entities.abstracts.Payment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterPayments {

    public static List<Payment> payments = new ArrayList<>();

    public static PaymentPix registerPix(Scanner sc, Double valuePay) {
        System.out.print("Qual o número da conta? ");
        Long numberAcc = sc.nextLong();

        PaymentPix pix = new PaymentPix(valuePay, RegisterClient.listClients.get(0), numberAcc);

        pix.generateCodeToPay();

        payments.add(pix);

        return pix;
    }

    public static PaymentCredit registerCredit(Scanner sc, Double valuePay) {
        System.out.print("Número do cartão: ");
        Long numberCard = sc.nextLong();

        System.out.print("CVV: ");
        sc.nextLine();
        String cvv = sc.nextLine();

        System.out.print("Data de validade: ");
        String patternDay = "01/";
        LocalDate dateValidate = LocalDate.parse(patternDay + sc.next(), PaymentCredit.formatDate);

        PaymentCredit credit = new PaymentCredit(valuePay, RegisterClient.listClients.get(0), numberCard, cvv, dateValidate);

        payments.add(credit);

        return credit;
    }

    public static PaymentDebit registerDebit(Scanner sc, Double valuePay) {
        PaymentDebit debit = new PaymentDebit();

        payments.add(debit);

        return debit;
    }

    public static PaymentMoney registerMoney(Scanner sc, Double valuePay) {
        PaymentMoney money = new PaymentMoney();

        payments.add(money);

        return money;
    }

}
