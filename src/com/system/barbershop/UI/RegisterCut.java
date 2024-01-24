package com.system.barbershop.UI;

import com.system.barbershop.entities.Cut;

import java.util.ArrayList;
import java.util.List;

public class RegisterCut {

    public static List<Cut> listCuts = new ArrayList<>();

    public static void register() {
        listCuts.add(new Cut("Degradê baixo", "Degradê baixo feito na zero ou na navalha", 15.00));
        listCuts.add(new Cut("Americano", "Corte estiloso e moderno", 10.00));
        listCuts.add(new Cut("Social", "Corte clássico feito na tesoura ou na máquina", 10.00));
        listCuts.add(new Cut("Degradê alto", "Degradê alto feito na zero", 15.00));
        listCuts.add(new Cut("Corte du jaca", "Corte da atualidade, criado no RJ. Atualmente é a moda do momento", 15.00));
    }

}
