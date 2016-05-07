package ohtu.kivipaperisakset.pelimallit;

import java.util.Scanner;
import ohtu.kivipaperisakset.tekoaly.TekoalyMuistava;

public class KPSParempiTekoaly extends Pelimalli {

    public KPSParempiTekoaly(Scanner lukija) {
        super(lukija);
        
        int muistinMaara = 20;
        super.tekoaly = new TekoalyMuistava(muistinMaara);
    }

    @Override
    public void pelaa() {
        super.pelaa();
    }

}
