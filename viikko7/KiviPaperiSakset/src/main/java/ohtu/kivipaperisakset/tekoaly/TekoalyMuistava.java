package ohtu.kivipaperisakset.tekoaly;

import java.util.HashMap;
import java.util.Map;

public class TekoalyMuistava implements Tekoaly {

    private String[] muisti;
    private int vapaaMuistiIndeksi;

    public TekoalyMuistava(int muistinKoko) {
        muisti = new String[muistinKoko];
        vapaaMuistiIndeksi = 0;
    }

    @Override
    public void asetaSiirto(String siirto) {
        if (muistiTaynna()) {
            siirraAlkioidenPaikkaaAiemmaksiUnohtaenEka();
        }

        muisti[vapaaMuistiIndeksi] = siirto;
        vapaaMuistiIndeksi++;
    }

    private boolean muistiTaynna() {
        return vapaaMuistiIndeksi == muisti.length;
    }

    private void siirraAlkioidenPaikkaaAiemmaksiUnohtaenEka() {
        for (int i = 1; i < muisti.length; i++) {
            muisti[i - 1] = muisti[i];
        }
        vapaaMuistiIndeksi--;
    }

    @Override
    public String annaSiirto() {
        if (vapaaMuistiIndeksi == 0 || vapaaMuistiIndeksi == 1) {
            return "k";
        }

        return annaSiirtoAiempienSiirtojenPerusteella(laskeMaarat());
    }
    
    private String annaSiirtoAiempienSiirtojenPerusteella(Map<String, Integer> siirrot) {
        int k = siirrot.get("k");
        int p = siirrot.get("s");
        int s = siirrot.get("s");
        
        if (kiviaEnemmanKuinPapereja(k, p) && kiviaEnemmanKuinSaksia(k, s)) {
            return "p";
        } else if (!kiviaEnemmanKuinPapereja(k, p) && paperiaEnemmanKuinSaksia(p, s)) {
            return "s";
        }

        return "k";
    }
    
    private Map<String, Integer> laskeMaarat() {
        Map<String, Integer> siirrot = new HashMap<>();
        siirrot.put("k", 0);
        siirrot.put("p", 0);
        siirrot.put("s", 0);
        
        String viimeisinSiirto = muisti[vapaaMuistiIndeksi - 1];       
        
        for (int i = 0; i < vapaaMuistiIndeksi - 1; i++) {
            if (viimeisinSiirto.equals(muisti[i])) {

                String seuraava = muisti[i + 1];
                siirrot.put(seuraava, siirrot.get(seuraava) + 1);
            }
        }
        return siirrot;
    }

    private boolean kiviaEnemmanKuinPapereja(int k, int p) {
        return k > p;
    }

    private boolean kiviaEnemmanKuinSaksia(int k, int s) {
        return k > s;
    }

    private boolean paperiaEnemmanKuinSaksia(int p, int s) {
        return p > s;
    }

}
