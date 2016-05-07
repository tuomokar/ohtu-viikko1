package ohtu.kivipaperisakset.pelimallit;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends Pelimalli {

    public KPSPelaajaVsPelaaja(Scanner lukija) {
        super(lukija);
    }
    
    @Override
    protected String annaTokanSiirto() {
        return lukija.nextLine();
    }
    
    @Override
    protected String hoidaTokanSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = annaTokanSiirto();

        return tokanSiirto;
    }
}
