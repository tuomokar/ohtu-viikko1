
package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;


public class Nollaus extends Komento {

    public Nollaus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(tuloskentta, syotekentta, sovellus);
    }
    
    @Override
    public void suorita() {
        sovellus.nollaa();
        asetaUusiTulos();
    }

    @Override
    public void peru() {
        asetaEdellinen();
    }
    
}
