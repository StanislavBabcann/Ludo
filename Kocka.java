import java.util.Random;

/**
  Trieda Kocka.
  
 * @author (Babcan)
 * @verison (7.1.2021)
 */
public class Kocka {
    private static int hodenaHodnota;
    private static Stvorec zobrazenieKocky;
    private static Kruh[] zobrazenieHodnoty;
    
    /**
     * konstruktor triedy Kocka
     * inicializuje atributy triedy na dane hodnoty
     */
    public Kocka() {
        hodenaHodnota = 0;
        zobrazenieKocky = new Stvorec();
        zobrazenieHodnoty = new Kruh[6];
    }
    
    /**
     * vygeneruje nahodne cislo v rozsahu 1-6
     */
    public void hodKockou() {
        Random r = new Random();
        int min = 1;
        int max = 6;
        int hod = r.nextInt((max - min) + 1) + min;
        hodenaHodnota = hod;
        this.zobrazKocku();
        
    }
    
    /**
     * @return vrati hodnotu atrubutu hodenaHodnota
     */
    public int dajHodenuHodnotu() {
        return hodenaHodnota;
    }
    
    /**
     * zobrazi kocku na platne
     * na zaklade hodenej hodnoty rozmiestni bodky po kocke
     */
    public void zobrazKocku() {
        zobrazenieKocky.zobraz();
        this.vytvorBodky();
        
        for (int i = 0; i < hodenaHodnota; i++) {
            if (i == 0) {
                zobrazenieHodnoty[0].setSuradnice(727, 515);
            } else if (i == 1) {
                zobrazenieHodnoty[0].setSuradnice(707, 495);
                zobrazenieHodnoty[1].setSuradnice(747, 535);
            } else if (i == 2) {
                zobrazenieHodnoty[2].setSuradnice(727, 515);
            } else if (i == 3) {
                zobrazenieHodnoty[2].setSuradnice(747, 495);
                zobrazenieHodnoty[3].setSuradnice(707, 535);
            } else if (i == 4) {
                zobrazenieHodnoty[4].setSuradnice(727, 515);
            } else if (i == 5) {
                zobrazenieHodnoty[4].setSuradnice(707, 515);
                zobrazenieHodnoty[5].setSuradnice(747, 515);
            }
            
        }
        
        for (int i = 0; i < hodenaHodnota; i++) {
            zobrazenieHodnoty[i].zobraz();
        }
    }
    
    /**
     * vytvori bodky na kocku na zaklade hodnoty atributu hodenaHodnota
     */
    private void vytvorBodky() {
        for (int i = 0; i < hodenaHodnota; i++) {
            zobrazenieHodnoty[i] = new Kruh("black");
            zobrazenieHodnoty[i].zmenPriemer(15);
        }
    }
    
}
