package ohtu;

import ohtu.verkkokauppa.Generaattori;
import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Kirjanpito;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Rahanhandlaaja;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Varastoija;
import ohtu.verkkokauppa.Viitegeneraattori;

public class Main {

    public static void main(String[] args) {
        Kirjanpito kirjanpito = new Kirjanpito();
        Rahanhandlaaja pankki = new Pankki(kirjanpito);
        Varastoija varasto = new Varasto(kirjanpito);
        Generaattori viitegeneraattori = new Viitegeneraattori();
        
        Kauppa kauppa = new Kauppa(varasto, pankki,
                viitegeneraattori);

        /*
        public Kauppa(Varastoija varasto, RahanHandlaaja pankki,
            Kori ostoskori, Generaattori viitegeneraattori) {
         */
        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }
}
