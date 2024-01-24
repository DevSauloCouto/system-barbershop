package com.system.barbershop.services;

import com.system.barbershop.entities.*;
import com.system.barbershop.entities.abstracts.Payment;
import com.system.barbershop.entities.enums.StatusSchedule;
import com.system.barbershop.exceptions.DateInvalidException;
import com.system.barbershop.services.interfaces.IScheduleService;

import java.time.LocalDateTime;

public class ScheduleService implements IScheduleService {

    private Schedule schedule;

    public ScheduleService(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public Boolean isValidDate(String newDate) throws DateInvalidException {
        if (LocalDateTime.parse(newDate, Schedule.formatDate).isBefore(LocalDateTime.now())) {
            throw new DateInvalidException("Não é possível realizar ou alterar um agendamento para datas passadas");
        }

        return true;
    }

    public Boolean isExistPayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Para realizar um agendamento é necessário ter informações sobre o pagamento.");
        }

        return true;
    }

    @Override
    public void assignStatusSchedule(Payment payment) {
        if (payment instanceof PaymentCredit) {
            this.schedule.setStatus(StatusSchedule.PENDING_PAYMENT);;
        }
        if (payment instanceof PaymentDebit) {
            this.schedule.setStatus(StatusSchedule.PENDING_PAYMENT);
        }
        if (payment instanceof PaymentPix) {
            this.schedule.setStatus(StatusSchedule.PENDING_PAYMENT);
        }
        if (payment instanceof PaymentMoney) {
            this.schedule.setStatus(StatusSchedule.CONFIRMED);
        }
    }

}
