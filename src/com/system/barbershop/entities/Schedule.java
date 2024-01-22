package com.system.barbershop.entities;

import com.system.barbershop.entities.abstracts.Payment;
import com.system.barbershop.entities.enums.StatusSchedule;
import com.system.barbershop.entities.interfaces.IScheduleRepository;
import com.system.barbershop.exceptions.DateInvalidException;
import com.system.barbershop.services.ScheduleService;
import com.system.barbershop.services.interfaces.IScheduleService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Schedule implements IScheduleRepository {

    private IScheduleService scheduleService = new ScheduleService(this);

    public static DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private UUID id;
    private LocalDateTime dateSchedule;
    private Payment payment;
    private StatusSchedule status;
    private Cut cut;
    private UUID clientId;

    public Schedule() {}

    public Schedule(String dateSchedule, Payment payment, Cut cut, UUID clientId) throws DateInvalidException {
        this.id = UUID.randomUUID();
        if(scheduleService.isValidDate(dateSchedule)) {
            this.dateSchedule = LocalDateTime.parse(dateSchedule, formatDate);
        }
        this.payment = payment;
        this.cut = cut;
        this.clientId = clientId;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateSchedule;
    }

    public Payment getPayment() {
        return payment;
    }

    public StatusSchedule getStatus() {
        return status;
    }

    public Cut getCut() {
        return cut;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setStatus(StatusSchedule status) {
        this.status = status;
    }
    public void setDateTime(String newDateSchedule) {
        this.dateSchedule = LocalDateTime.parse(newDateSchedule, formatDate);
    }

    @Override
    public String toString() {
        return "id-schedule="
                + id
                + " date-schedule="
                + dateSchedule
                + " payment="
                + payment
                + " status="
                + status.toString()
                + " cut="
                + cut
                + " id-client="
                + clientId;
    }


}
