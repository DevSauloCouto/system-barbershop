package com.system.barbershop.services.interfaces;

import com.system.barbershop.entities.Schedule;
import com.system.barbershop.exceptions.DateInvalidException;
import com.system.barbershop.exceptions.NotFoundResourceException;
import com.system.barbershop.exceptions.ScheduleException;

import java.util.UUID;

public interface IClientService {

    public void saveSchedule(Schedule schedule) throws ScheduleException, DateInvalidException;
    public void cancelSchedule(UUID idSchedule) throws NotFoundResourceException;
    public void changeDateSchedule(String newDate, UUID idSchedule) throws NotFoundResourceException, DateInvalidException;

}
