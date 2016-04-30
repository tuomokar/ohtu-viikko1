
package ohtu.komennot;

import ohtu.komennot.Komento;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public class Komentotehdas {
    
    private Map<Object, Komento> komennot;
    
    private JButton plus;
    private JButton miinus;
    private JButton nollaa;
    private JTextField tuloskentta; 
    private JTextField syotekentta;
    
    private Komento edellinen;

    public Komentotehdas(Sovelluslogiikka sovelluslogiikka, Object plus, 
            Object miinus, Object nollaa,
            JTextField tuloskentta, JTextField syotekentta) {
        
        komennot = new HashMap<>();
        komennot.put(plus, new Summa(sovelluslogiikka, tuloskentta, syotekentta));
        komennot.put(miinus, new Erotus(sovelluslogiikka, tuloskentta, syotekentta));
        komennot.put(nollaa, new Nollaus(sovelluslogiikka, tuloskentta, syotekentta));
    }
    
    public Komento hae(Object nappi) {
        Komento komento = komennot.get(nappi);
        
        if (komento != null) {
            edellinen = komento;
        }
        
        return komento;
    }
    
    public Komento getEdellinen() {
        return edellinen;
    }
}
