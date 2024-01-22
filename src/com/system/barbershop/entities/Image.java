package com.system.barbershop.entities;

import java.util.UUID;

public class Image {

    private UUID id;
    private String format;
    private String pathFile;
    private Double size;

    public Image() {}

    public UUID getId() {
        return id;
    }

    public String getFormat() {
        return format;
    }

    public String getPathFile() {
        return pathFile;
    }

    public Double getSize() {
        return size;
    }

    public Image(String format, String pathFile, Double size) {
        this.id = UUID.randomUUID();
        this.format = format;
        this.pathFile = pathFile;
        this.size = size;
    }

}
