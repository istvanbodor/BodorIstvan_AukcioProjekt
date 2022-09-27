package hu.petrik.aukcioprojekt;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Festmeny> festmenyek = new ArrayList<>();

    public static void main(String[] args) {

        Festmeny festmeny = new Festmeny("Galambok a hősök terén", "Gipsz Jakab", "Expresszionizmus");
        Festmeny festmeny2 = new Festmeny("Budapest éjszaka", "Teszt Elek", "Expresszionizmus");
        festmenyek.add(festmeny);
        festmenyek.add(festmeny2);
        try {
            festmenyekFelveteleKonzolrol();
        } catch (InputMismatchException e) {
            System.out.println("Nem megfelelő számot adott meg nem lesz felvéve a festmény");
        }

    }
    private static void festmenyekFelveteleKonzolrol()
    {
    Scanner sc = new Scanner(System.in);
        System.out.println("Adja meg hány festményt szeretne felvenni: ");
        int db = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i <db ; i++) {
            System.out.printf("Adja meg a(z) %d festmény címét:",i+1);
            String cim = sc.nextLine();
            System.out.printf("Adja meg a(z) %d festmény festőjét:", i+1);
            String festo = sc.nextLine();
            System.out.printf("Adja meg a(z) %d festmény stílusát:", i+1);
            String stilus = sc.nextLine();
            Festmeny festmeny = new Festmeny(cim, festo, stilus);
            festmenyek.add(festmeny);
        }



    }
}
