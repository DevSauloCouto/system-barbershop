package com.system.barbershop.application;

import com.system.barbershop.UI.MenuOptions;
import com.system.barbershop.UI.RegisterCut;

import java.util.Scanner;

public class Program {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RegisterCut.register();

        while (true) {
            MenuOptions.show(sc);
        }

    }

}
