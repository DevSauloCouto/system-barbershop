package com.system.barbershop.entities;

import com.system.barbershop.entities.interfaces.ICutRepository;

import java.util.ArrayList;
import java.util.List;

public class Cut implements ICutRepository {

    private String title;
    private String details;
    private List<Image> images = new ArrayList<>();
    private Double price;

    public Cut() {}

    public Cut(String title, String details, Double price) {
        this.title = title;
        this.details = details;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public List<Image> getListImages() {
        return images;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "title="
                + title
                + " details="
                + details
                + " price="
                + price;
    }

}