package ohtu.kivipaperisakset;

public class Tuomari {

    private int ekanPisteet;
    private int tokanPisteet;
    private int tasapelit;

    public void kirjaaSiirto(String ekanSiirto, String tokanSiirto) {
        if (tasapeli(ekanSiirto, tokanSiirto)) {
            tasapelit++;
        } else if (ekaVoittaa(ekanSiirto, tokanSiirto)) {
            ekanPisteet++;
        } else {
            tokanPisteet++;
        }
    }

    private static boolean tasapeli(String eka, String toka) {
        return eka.equals(toka);
    }

    private static boolean ekaVoittaa(String eka, String toka) {
        if (eka.equals("k") && toka.equals("s")) {
            return true;
        } else if (eka.equals("s") && toka.equals("p")) {
            return true;
        } else if (eka.equals("p") && toka.equals("k")) {
            return true;
        }

        return false;
    }

    public String toString() {
        String s = "Pelitilanne: " + ekanPisteet + " - " + tokanPisteet + "\n"
                + "Tasapelit: " + tasapelit;
        return s;
    }
}