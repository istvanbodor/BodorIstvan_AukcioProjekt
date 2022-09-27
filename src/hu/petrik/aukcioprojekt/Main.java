package hu.petrik.aukcioprojekt;

public class Main {


    public static void main(String[] args) {
        Festmeny festmeny = new Festmeny("Hómező", "Bálint Ferenc", "Expresszionizmus");
        for (int i = 0; i < 15; i++) {
            festmeny.licit(10);
            System.out.println(festmeny);
        }
    }
}
