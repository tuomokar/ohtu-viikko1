
package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;


public class Erotus extends Komento {

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(tuloskentta, syotekentta, sovellus);
    }
    
    @Override
    public void suorita() {
        sovellus.miinus(getArvo());
        asetaUusiTulos();
    }

    @Override
    public void peru() {
        asetaEdellinen();
    }
    
}
