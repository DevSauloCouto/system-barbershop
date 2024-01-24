package com.system.barbershop.UI;

import com.system.barbershop.application.Program;

import java.util.HashMap;
import java.util.Scanner;

public class MenuOptions {

    public static void show(Scanner sc) {

        System.out.println("Menu de opções...");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Agendar");
        System.out.println("3 - Cadastrar informações de pagamento");
        System.out.println("4 - Alterar data do agendamento");
        System.out.println("5 - Cancelar agendamento");
        System.out.println("6 - Sair");
        System.out.println("");

        System.out.print("O que deseja fazer? ");
        int chooseOption = sc.nextInt();

        if (chooseOption == 1) {
            RegisterClient.register(sc);
        }
        if (chooseOption == 2) {
            sc.nextLine();
            RegisterSchedule.register(sc);
        }

    }

}
