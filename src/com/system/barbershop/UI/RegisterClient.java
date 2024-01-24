package com.system.barbershop.UI;

import com.system.barbershop.entities.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterClient {

    public static List<Client> listClients = new ArrayList<>();

    public static void register(Scanner sc) {
        System.out.println("");
        System.out.println("Olá, Bem Vindo a Barbearia Valter Cortes. Somos um time especializado em diversos tipos de serviços relacionados a Cortes, Tinturas e tudo que envolve beleza e estética.");
        System.out.println("Dúvidas entre em contato com (79) 98889-2918");
        System.out.println("");
        System.out.println("Vamos realizar um cadastro?");

        System.out.print("Digite seu nome: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Digite seu email: ");
        String email = sc.nextLine();

        System.out.print("Digite seu telefone: ");
        String phone = sc.nextLine();

        System.out.print("Digite sua senha: ");
        String password = sc.nextLine();

        Client client = new Client(name, email, phone, password);

        listClients.add(client);

        System.out.println("Cliente cadastrado com sucesso! :)\n");
    }

}
