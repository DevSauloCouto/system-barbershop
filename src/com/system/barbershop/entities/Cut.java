package com.system.barbershop.entities;

import java.util.ArrayList;
import java.util.List;

public class Cut {

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
        return "Nome: " + title + "\n" + "Detalhes: " + details + "\n" + "Preço: R$" + price + "\n";
    }

}
