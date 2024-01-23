package com.system.barbershop.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {

    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private List<Schedule> listSchedule = new ArrayList<>();

    public Client() {}

    public Client(String name, String email, String phone, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public List<Schedule> getListSchedule() {
        return this.listSchedule;
    }

    @Override
    public String toString() {
        return "name="
                + name
                + " email="
                + email
                + " phone="
                + phone;
    }

}
