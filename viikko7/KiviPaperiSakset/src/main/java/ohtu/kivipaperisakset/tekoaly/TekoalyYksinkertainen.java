package ohtu.kivipaperisakset.tekoaly;

import java.util.HashMap;
import java.util.Map;

public class TekoalyYksinkertainen implements Tekoaly {

    int siirto;
    private Map<Integer, String> siirrot;

    public TekoalyYksinkertainen() {
        siirto = 0;
        siirrot = new HashMap<>();
        siirrotMappiin();
    }
    
    private void siirrotMappiin() {
        siirrot.put(0, "k");
        siirrot.put(1, "p");
        siirrot.put(2, "s");
    }

    @Override
    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;
        
        return siirrot.get(siirto);
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }
}
