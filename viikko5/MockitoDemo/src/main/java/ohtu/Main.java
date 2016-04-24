package ohtu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Pankki myNetBank = new Pankki();
//        Viitegeneraattori viitteet = new Viitegeneraattori();
//        Kauppa kumpulaBiershop = new Kauppa(myNetBank, viitteet);
//
//        kumpulaBiershop.aloitaOstokset();
//        kumpulaBiershop.lisaaOstos(10);
//        kumpulaBiershop.lisaaOstos(7);
//        kumpulaBiershop.maksa("1234-1234");
//
//        kumpulaBiershop.aloitaOstokset();
//        kumpulaBiershop.lisaaOstos(1);
//        kumpulaBiershop.lisaaOstos(1);
//        kumpulaBiershop.lisaaOstos(2);
//        kumpulaBiershop.lisaaOstos(2);
//        kumpulaBiershop.maksa("4444-1111");

        Scanner reader = new Scanner(System.in);

        System.out.println("Type a year: ");
        int year = Integer.parseInt(reader.nextLine());
        
//        System.out.println(!(year % 100 == 0 && year % 400 == 0));
//        System.out.println(year % 10 == 0 || year % 400 == 0);
//
//        if (!(year % 100 == 0 && year % 400 == 0) && !(year % 4 == 0)) {
//            System.out.println("The year is not a leap year.");
//        } else {
//            System.out.println("The year is a leap year");
//        }

        if (year % 4 == 0) {
            System.out.println("is a leap year");
        } else if (true){
        
        } else {
            System.out.println("is not a leap year");
        }
    }
}
