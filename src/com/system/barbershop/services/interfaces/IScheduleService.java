package com.system.barbershop.services.interfaces;

import com.system.barbershop.entities.abstracts.Payment;
import com.system.barbershop.exceptions.DateInvalidException;

public interface IScheduleService {

    public Boolean isValidDate(String newDate) throws DateInvalidException;
    public Boolean isExistPayment(Payment payment) throws IllegalArgumentException;
    public void assignStatusSchedule(Payment payment);

}
