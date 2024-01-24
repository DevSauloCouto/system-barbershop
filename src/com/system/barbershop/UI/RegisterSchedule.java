package com.system.barbershop.UI;

import com.system.barbershop.entities.Cut;
import com.system.barbershop.entities.PaymentMoney;
import com.system.barbershop.entities.Schedule;
import com.system.barbershop.entities.abstracts.Payment;
import com.system.barbershop.entities.enums.StatusSchedule;
import com.system.barbershop.exceptions.DateInvalidException;
import com.system.barbershop.exceptions.NotFoundResourceException;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RegisterSchedule {

    public static List<Schedule> listSchedules = new ArrayList<>();

    public static void register(Scanner sc) {
        System.out.println("Vamos realizar um agendamento?");

        LocalDateTime localDateTime = null;

        while (localDateTime == null) {
            System.out.print("Comece nos informando a data e hora (dd/mm/yyyy HH:MM): ");
            String date = sc.nextLine();

            try {
                localDateTime = LocalDateTime.parse(date, Schedule.formatDate);
            }
            catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
            }

        }

        Cut chooseCut = null;

        while (chooseCut == null) {
            try {
                System.out.println("Cortes disponíveis: ");

                for (Cut cut : RegisterCut.listCuts) {
                    System.out.println(cut);
                }

                System.out.print("Qual corte deseja (nome)? ");
                String nameCut = sc.nextLine();

                Cut cut = RegisterCut.listCuts
                        .stream()
                        .filter( c -> c.getTitle().toLowerCase().equals(nameCut.toLowerCase()))
                        .findFirst()
                        .orElseThrow(() -> new NotFoundResourceException("Não existe nenhum corte com este nome, por favor escolha uma das opções disponíveis!"));

                chooseCut = cut;
            }
            catch (NotFoundResourceException e) {
                System.out.println(e.getMessage());
            }
        }

        Payment payment = null;

        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Pix");
        System.out.println("2 - Crédito");
        System.out.println("3 - Débito");
        System.out.println("4 - Dinheiro");
        System.out.print("Qual será a forma de pagamento? ");

        int choosePayment = sc.nextInt();

        while (payment == null) {
            try {
                if (choosePayment < 1 && choosePayment > 4) {
                    throw new IllegalArgumentException("Por favor, escolha uma opção válida!");
                }

                if (choosePayment == 1) {
                    payment = RegisterPayments.registerPix(sc, chooseCut.getPrice());
                }
                if (choosePayment == 2) {
                    payment = RegisterPayments.registerCredit(sc, chooseCut.getPrice());
                }
                if (choosePayment == 3) {
                    payment = RegisterPayments.registerDebit(sc, chooseCut.getPrice());
                }
                if (choosePayment == 4) {
                    payment = RegisterPayments.registerMoney(sc, chooseCut.getPrice());
                }

                System.out.println("\nConfira as informações antes de realizar o pagamento:");
                System.out.println("\nCorte: " + chooseCut.getTitle());
                System.out.println(payment);

                System.out.print("\nConfirmar? (s/n) ");
                char ch = sc.next().charAt(0);

                if (ch == 's' && !(payment instanceof PaymentMoney)) {
                    //refatorar depois
                    System.out.println("\nAguardando pagamento...");
                    payment.pay();
                } else if (ch == 's' && payment instanceof PaymentMoney) {
                    System.out.println("Pagamento será realizado no local!");
                } else {
                    System.out.println("Tente novamente mais tarde...");
                    payment = null;
                    break;
                }

            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            Schedule schedule = new Schedule(localDateTime.format(Schedule.formatDate), payment, chooseCut, RegisterClient.listClients.get(0));

            if (schedule.getPayment().pay() && schedule.getStatus() != StatusSchedule.CONFIRMED) {
                schedule.setStatus(StatusSchedule.CONFIRMED);
            }

            listSchedules.add(schedule);

            System.out.println("Agendamento realizado com sucesso! :)\n");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (DateInvalidException e) {
            System.out.println(e.getMessage());
        }

    }

}
