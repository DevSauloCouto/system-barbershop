package com.system.barbershop.services.interfaces;

import com.system.barbershop.entities.Image;
import com.system.barbershop.exceptions.NotFoundResourceException;

import java.util.Optional;
import java.util.UUID;

public interface ICutService {

    public Image findImageById(UUID idImage) throws NotFoundResourceException;
    public void addImage(Image image);
    public void removeImage(UUID idImage) throws NotFoundResourceException;


}
