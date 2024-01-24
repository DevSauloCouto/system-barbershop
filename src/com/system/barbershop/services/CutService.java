package com.system.barbershop.services;

import com.system.barbershop.entities.Cut;
import com.system.barbershop.entities.Image;
import com.system.barbershop.exceptions.NotFoundResourceException;
import com.system.barbershop.services.interfaces.ICutService;

import java.util.UUID;

public class CutService implements ICutService {

    private Cut cut;

    public CutService(Cut cut) {
        this.cut = cut;
    }

    @Override
    public Image findImageById(UUID idImage) throws NotFoundResourceException {
        return this.cut.getListImages()
                .stream()
                .filter( img -> img.getId().equals(idImage))
                .findFirst()
                .orElseThrow(() -> new NotFoundResourceException("Not Found Image Cut - 404"));
    }

    @Override
    public void addImage(Image image) {
        this.cut.getListImages().add(image);
    }

    @Override
    public void removeImage(UUID idImage) throws NotFoundResourceException {
        Image image = this.findImageById(idImage);
        this.cut.getListImages().remove(image);
    }

}
