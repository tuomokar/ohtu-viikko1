package ohtu.kivipaperisakset.pelimallit;

import java.util.Scanner;
import ohtu.kivipaperisakset.Tuomari;
import ohtu.kivipaperisakset.tekoaly.Tekoaly;

public abstract class Pelimalli {

    protected Scanner lukija;
    protected Tekoaly tekoaly;

    public Pelimalli(Scanner lukija) {
        this.lukija = lukija;
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        while (true) {
            System.out.print("Ensimmäisen pelaajan siirto: ");
            String ekanSiirto = lukija.nextLine();

            String tokanSiirto = hoidaTokanSiirto();

            if (siirtoEiOk(ekanSiirto) || siirtoEiOk(tokanSiirto)) {
                break;
            }

            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            if (onTekoalyPeli()) {
                tekoaly.asetaSiirto(ekanSiirto);
            }

        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    private boolean onTekoalyPeli() {
        return tekoaly != null;
    }
    
    private boolean siirtoEiOk(String siirto) {
        return !siirto.equals("k") && !siirto.equals("p") && !siirto.equals("s");
    }

    protected String hoidaTokanSiirto() {
        String tokanSiirto = annaTokanSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }

    protected String annaTokanSiirto() {
        return tekoaly.annaSiirto();
    }

    public static Pelimalli luoKPSTekoaly(Scanner lukija) {
        return new KPSTekoaly(lukija);
    }

    public static Pelimalli luoKPSParempiTekoaly(Scanner lukija) {
        return new KPSParempiTekoaly(lukija);
    }

    public static Pelimalli luoKPSPelaajaVsPelaaja(Scanner lukija) {
        return new KPSPelaajaVsPelaaja(lukija);
    }

}
