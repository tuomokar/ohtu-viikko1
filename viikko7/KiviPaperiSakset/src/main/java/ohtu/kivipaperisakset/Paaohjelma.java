package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.pelimallit.Pelimalli;
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = lukija.nextLine();
            
            if (lopetetaan(vastaus)) {
                break;
            }
            
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            Pelimalli pelimalli;
            
            if (vastaus.endsWith("a")) {
                pelimalli= Pelimalli.luoKPSPelaajaVsPelaaja(lukija);
            } else if (vastaus.endsWith("b")) {
                pelimalli = Pelimalli.luoKPSTekoaly(lukija);
            } else {
                pelimalli = Pelimalli.luoKPSParempiTekoaly(lukija);
            }
            
            pelimalli.pelaa();

        }

    }
    
    private static boolean lopetetaan(String vastaus) {
        return !vastaus.endsWith("a") && !vastaus.endsWith("b") && !vastaus.endsWith("c");
    }
}
