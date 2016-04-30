package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import ohtu.komennot.Komento;
import ohtu.komennot.Komentotehdas;

public class Tapahtumankuuntelija implements ActionListener {

    private JButton nollaa;
    private JButton undo;
    private Sovelluslogiikka sovellus;
    private Komentotehdas komentotehdas;

    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, 
            JTextField tuloskentta, JTextField syotekentta) {
               
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        komentotehdas = new Komentotehdas(sovellus, plus, miinus, nollaa, tuloskentta, syotekentta);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Komento komento = komentotehdas.hae(ae.getSource());
        
        if (komento != null) {
            komento.suorita();
        } else {
            komentotehdas.getEdellinen().peru();
        }

        nollaa.setEnabled(onkoTulosNolla());
        undo.setEnabled(true);
    }
    
    private boolean onkoTulosNolla() {
        return sovellus.tulos() != 0;
    }

}
