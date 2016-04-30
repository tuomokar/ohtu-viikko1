
package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

public abstract class Komento {
    
    protected Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    
    private int edellinenTulos;
    
    public Komento(JTextField tuloskentta, JTextField syotekentta, 
            Sovelluslogiikka sovellus) {
        
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = sovellus;
    }
    
    protected int getArvo() {
        int arvo = 0;
        try {
            arvo =  Integer.parseInt(syotekentta.getText());
        } catch (NumberFormatException e) {
            System.out.println("Annettiin kokonaisluku tai syöte on tyhjä");
        }
        
        return arvo;
    }
    
    protected void asetaUusiTulos() {
        edellinenTulos = Integer.parseInt(tuloskentta.getText());

        asetaTulos(sovellus.tulos());
    }
    
    protected void asetaEdellinen() {
        sovellus.asetaEdellinenTulokseksi(edellinenTulos);
        
        asetaTulos(edellinenTulos);
    }
    
    private void asetaTulos(int tulos) {
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);
    }
    
    public abstract void suorita();
    public abstract void peru();
}
