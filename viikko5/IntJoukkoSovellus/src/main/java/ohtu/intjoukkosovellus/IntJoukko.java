package ohtu.intjoukkosovellus;

import java.util.Arrays;
import java.util.Collections;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Sekä kapasiteetin että kasvatuskoon pitää olla vähintään nolla!");
        }
        lukujono = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    private boolean alkioitaNolla() {
        return alkioidenLkm == 0;
    }

    private void lisaaTaulukkoon(int luku) {
        lukujono[alkioidenLkm] = luku;
    }

    public boolean lisaa(int luku) {

        if (sisaltaa(luku)) {
            return false;
        }

        lisaaTaulukkoon(luku);
        alkioidenLkm++;

        if (ollaanTaulukonLopussa()) {
            muodostaUusiTaulukkoVanhoillaArvoillaJaKasvatetullaKoolla();
        }

        return true;
    }

    private void muodostaUusiTaulukkoVanhoillaArvoillaJaKasvatetullaKoolla() {
        lukujono = Arrays.copyOf(lukujono, kasvatettuKoko());
    }

    private int kasvatettuKoko() {
        return alkioidenLkm + kasvatuskoko;
    }

    private boolean ollaanTaulukonLopussa() {
        return alkioidenLkm % lukujono.length == 0;
    }

    public boolean sisaltaa(int luku) {
        for (int l : lukujono) {
            if (luku == l) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                lukujono[i] = 0;
                siirraSeuraavienAlkioidenPaikkaaAiemmaksi(i);
                return true;
            }
        }
        return false;
    }

    private void siirraSeuraavienAlkioidenPaikkaaAiemmaksi(int i) {
        for (int j = i; j < alkioidenLkm - 1; j++) {
            lukujono[j] = lukujono[j + 1];
        }
        alkioidenLkm--;
    }

    public int getAlkioidenLukumaara() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        }
        return alkiotMerkkijonona();
    }

    private String alkiotMerkkijonona() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < alkioidenLkm - 1; i++) {
            sb.append(lukujono[i] + ", ");
        }
        sb.append(lukujono[alkioidenLkm - 1] + "}");
        return sb.toString();
    }

    public int[] toIntArray() {
        return Arrays.copyOf(lukujono, alkioidenLkm);
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko intJoukko = new IntJoukko();
        
        lisaaTaulukonArvotJoukkoon(intJoukko, a.toIntArray());
        lisaaTaulukonArvotJoukkoon(intJoukko, b.toIntArray());

        return intJoukko;
    }
    
    private static void lisaaTaulukonArvotJoukkoon(IntJoukko intJoukko, int[] taulukko) {
        for (int luku : taulukko) {
            intJoukko.lisaa(luku);
        }
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko joukko = new IntJoukko();
        
        lisaaJoukkojenRisteavatArvot(joukko, a, b);
        return joukko;
    }
    
    private static void lisaaJoukkojenRisteavatArvot(IntJoukko joukko, IntJoukko tutkittavaJoukko1, IntJoukko tutkittavaJoukko2) {
        int[] tutkittavatLuvut2 = tutkittavaJoukko2.toIntArray();
        
        for (int luku : tutkittavatLuvut2) {
            if (tutkittavaJoukko1.sisaltaa(luku)) {
                joukko.lisaa(luku);
            }
        }
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko joukko = new IntJoukko();
        
        lisaaEiRisteavatArvot(joukko, a, b);
        return joukko;
    }
    
    private static void lisaaEiRisteavatArvot(IntJoukko joukko, IntJoukko tutkittavaJoukko1, IntJoukko tutkittavaJoukko2) {
        int[] tutkittavatLuvut2Taulukkona = tutkittavaJoukko2.toIntArray();
        
        for (int luku : tutkittavatLuvut2Taulukkona) {
            if (!tutkittavaJoukko1.sisaltaa(luku)) {
                joukko.lisaa(luku);
            }
        }
    }
}
