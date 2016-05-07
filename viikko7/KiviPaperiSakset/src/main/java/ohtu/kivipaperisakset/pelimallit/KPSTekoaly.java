package ohtu.kivipaperisakset.pelimallit;

import java.util.Scanner;
import ohtu.kivipaperisakset.tekoaly.TekoalyYksinkertainen;

public class KPSTekoaly extends Pelimalli  {

    public KPSTekoaly(Scanner lukija) {
        super(lukija);
        super.tekoaly = new TekoalyYksinkertainen();
    }

    @Override
    public void pelaa() {
        super.pelaa();
    }
}