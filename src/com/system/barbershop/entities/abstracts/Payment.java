package com.system.barbershop.entities.abstracts;

import com.system.barbershop.entities.interfaces.IPaymentRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Payment implements IPaymentRepository {

    protected UUID id;
    protected Double valuePay;
    protected UUID idPayer;
    protected LocalDateTime datePayment;

    public Payment() {}

    public Payment(Double valuePay, UUID idPayer) {
        this.id = UUID.randomUUID();
        this.valuePay = valuePay;
        this.idPayer = idPayer;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public Double getValuePay() {
        return valuePay;
    }

    @Override
    public UUID getIdPayer() {
        return idPayer;
    }

    @Override
    public LocalDateTime getDatePayment() {
        return datePayment;
    }

    public abstract Boolean pay();

    @Override
    public String toString() {
        return "value="
                + valuePay
                + " payer="
                + idPayer;
    }
}
