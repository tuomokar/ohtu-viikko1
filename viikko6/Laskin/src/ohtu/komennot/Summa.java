package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public class Summa extends Komento {

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(tuloskentta, syotekentta, sovellus);
    }

    @Override
    public void suorita() {       
        sovellus.plus(super.getArvo());
        asetaUusiTulos();
    }

    @Override
    public void peru() {
        asetaEdellinen();
    }

}
