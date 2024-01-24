package com.system.barbershop.services;

import com.system.barbershop.entities.Client;
import com.system.barbershop.entities.Schedule;
import com.system.barbershop.entities.enums.StatusSchedule;
import com.system.barbershop.exceptions.DateInvalidException;
import com.system.barbershop.exceptions.NotFoundResourceException;
import com.system.barbershop.exceptions.ScheduleException;
import com.system.barbershop.services.interfaces.IClientService;
import com.system.barbershop.services.interfaces.IScheduleService;

import java.util.List;
import java.util.UUID;

public class ClientService implements IClientService {

    private Client client;

    public ClientService(Client client) {
        this.client = client;
    }

    @Override
    public void saveSchedule(Schedule schedule) throws ScheduleException {
        List<Schedule> list = this.client.getListSchedule()
                .stream()
                .filter( sched -> sched.getDateTime().getDayOfMonth() == schedule.getDateTime().getDayOfMonth()
                        && sched.getDateTime().getMonthValue() == schedule.getDateTime().getMonthValue())
                .toList();

        if(!list.isEmpty()) {
            throw new ScheduleException("It is not possible to schedule more than 1 time on the same day");
        }

        IScheduleService scheduleService = new ScheduleService(schedule);
        scheduleService.assignStatusSchedule(schedule.getPayment());

        this.client.getListSchedule().add(schedule);
    }

    @Override
    public void cancelSchedule(UUID idSchedule) throws NotFoundResourceException {
        Schedule schedule = this.client
                .getListSchedule()
                .stream()
                .filter( sched -> sched.getId().equals(idSchedule))
                .findFirst()
                .orElseThrow(() -> new NotFoundResourceException("Not Found Schedule - 404"));

        schedule.setStatus(StatusSchedule.CANCEL);
    }

    @Override
    public void changeDateSchedule(String newDate, UUID idSchedule) throws NotFoundResourceException, DateInvalidException {
        Schedule schedule = this.client.getListSchedule()
                .stream()
                .filter( sched -> sched.getId().equals(idSchedule) )
                .findFirst()
                .orElseThrow(() -> new NotFoundResourceException("Not Found Schedule - 404"));

        IScheduleService scheduleService = new ScheduleService(schedule);

        if(scheduleService.isValidDate(newDate)) {
            schedule.setDateTime(newDate);
        }
    }

}
