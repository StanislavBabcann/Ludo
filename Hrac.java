import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
  Trieda Hrac.
 * 
 * @author (Babcan)
 * @version (7.1.2021)
 */
public class Hrac {
    private String meno;
    private ArrayList<Figurka> zaciatocnyDomcek;
    private Figurka[] konecnyDomcek;
    private String farba;

    /**
     * konstruktor triedy Hrac s parametrami - vytvori hraca s danym menom a farbou
     * @param paMeno je meno hraca
     * @param paFarba je farba hraca
     */
    public Hrac(String paMeno, FarbaFigurky paFarba) {
        this.meno = paMeno;
        this.zaciatocnyDomcek = new ArrayList<Figurka>(4);
        this.farba = paFarba.getReprezentacia();
        
        for (int i = 0; i < 4; i++) {
            Figurka pomFigurka = new Figurka(this.farba, i + 1, i);
            this.zaciatocnyDomcek.add(pomFigurka);
           
        }
        this.konecnyDomcek = new Figurka[4];
    }
    
    //metody triedy
    /**
     * @return vrati boolean hodnotu po kontrole zadaneho vstupu
     * @param vstup je retazec String, ktory sa skontroluje
     */
    private static boolean kontrolaVstupu (String vstup) {
        try {
            Integer.parseInt(vstup);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    //metody instancie
    /**
     * @return vrati atribut meno
     */
    public String getMeno() {
        return this.meno;
    }
    
    /**
     * @return vrati atribut farba
     */
    public String getFarba() {
        return this.farba;
    }
    
    /**
     * @return vrati boolean hodnotu na zaklade toho, ci uz hrac naplnil svoj konecny domcek figurkami
     */
    public boolean skontrolujKonecnyDomcek() {
        for (int i = 0; i < this.konecnyDomcek.length; i++) {
            if (this.konecnyDomcek[i] == null) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * vrati figurku z hracej dosky do zaciatocneho domceka hraca
     * @param figurka je figurka daneho hraca, ktora sa odstranila z hracej dosky
     */
    public void dajFigurkuDoZaciatocnehoDomceka(Figurka figurka) {
        this.zaciatocnyDomcek.add(figurka);
        
        for (int i = 0; i < this.zaciatocnyDomcek.size(); i++) {
            if (this.zaciatocnyDomcek.get(i) == figurka) {
                figurka.setPozicia(i);
                
            } 
        }
    }
    
    /**
     * zobrazi graficky figurky v zaciatocnom domceku hraca na platne
     */
    public void zobrazZaciatocnyDomcek() {
        for (int i = 0; i < this.zaciatocnyDomcek.size(); i++) {
            Kruh pomKruh = this.zaciatocnyDomcek.get(i).getGrafickeZobrazenie();
                 
            if (this.farba.equals("modra")) {
                if (i == 0) {
                    pomKruh.setSuradnice(840, 100);
                } else if (i == 1) {
                    pomKruh.setSuradnice(870, 100);
                } else if (i == 2) {
                    pomKruh.setSuradnice(840, 130);
                } else if (i == 3) {
                    pomKruh.setSuradnice(870, 130);
                }
                    
            } else if (this.farba.equals("zelena")) {
                if (i == 0) {
                    pomKruh.setSuradnice(840, 370);
                } else if (i == 1) {
                    pomKruh.setSuradnice(870, 370);
                } else if (i == 2) {
                    pomKruh.setSuradnice(840, 400);
                } else if (i == 3) {
                    pomKruh.setSuradnice(870, 400);
                }      
                            
            } else if (this.farba.equals("cervena")) {
                if (i == 0) {
                    pomKruh.setSuradnice(570, 370);
                } else if (i == 1) {
                    pomKruh.setSuradnice(600, 370);
                } else if (i == 2) {
                    pomKruh.setSuradnice(570, 400);
                } else if (i == 3) {
                    pomKruh.setSuradnice(600, 400);
                }      
                            
            } else if (this.farba.equals("zlta")) {
                if (i == 0) {
                    pomKruh.setSuradnice(570, 100);
                } else if (i == 1) {
                    pomKruh.setSuradnice(600, 100);
                } else if (i == 2) {
                    pomKruh.setSuradnice(570, 130);
                } else if (i == 3) {
                    pomKruh.setSuradnice(600, 130);
                }      
            }
            pomKruh.zobraz();
                
        }
                
    }
    
    /**
     * zobrazi graficky figurky v konecnom domceku hraca na platne
     */
    public void zobrazKonecnyDomcek() {
        for (int i = 0; i < this.konecnyDomcek.length; i++) {
            Figurka pomFigurka = this.konecnyDomcek[i];
            Kruh pomKruh = null;
            if (pomFigurka != null) {
                pomKruh = pomFigurka.getGrafickeZobrazenie();
                
                if (this.farba.equals("modra")) {
                    pomKruh.setSuradnice(720, 130 + i * 30);
                } else if (this.farba.equals("zelena")) {
                    pomKruh.setSuradnice(840 - i * 30, 250);
                } else if (this.farba.equals("cervena")) {
                    pomKruh.setSuradnice(720, 370 - i * 30);
                } else if ( this.farba.equals("zlta")) {
                    pomKruh.setSuradnice(600 + i * 30, 250);
                }
                pomKruh.zobraz();
            }
                
        }
    }
    
    /**
     * po zadani korektneho cisla zisti, kde sa dana figurka nachadza
     * v pripade nekorektneho vstupu informuje pouzivatela
     * po zisteni lokacie figurky spusti prislusnu metodu v pripade, ze sa da spustit
     */
    public void zahrajFigurku() {
        int k = 0;
        // skontroluje konecny domcek hraca aby vedel ci mu ma vobec dat moznost zahrat
        while (k < this.konecnyDomcek.length) {
            if (this.konecnyDomcek[k] == null) {
                k = 0;
                break;
            } else {
                k++;
            }
        }
        
        
        if (k == this.konecnyDomcek.length) {
            JOptionPane.showMessageDialog( null, "Uz mate vsetky figurky v domceku!");
        } else {
            // v pripade ze v konecnom domceku je prazdna pozicia
            String vstup = JOptionPane.showInputDialog( null, "Zadaj cislo figurky, ktoru chces zahrat:") ;
            if (Hrac.kontrolaVstupu(vstup)) {
                int poradoveCislo = Integer.parseInt(vstup);
                if (poradoveCislo > 4 || poradoveCislo < 1) {
                    JOptionPane.showMessageDialog( null, "Neexistuje figurka s takymto poradovym cislom!");
                } else {
                    int i = 0;
                    // najskor zacne hladat v zaciatocnom domceku
                    if (!this.zaciatocnyDomcek.isEmpty()) {
                        while (i < this.zaciatocnyDomcek.size()) {
                            if (this.zaciatocnyDomcek.get(i).getPoradoveCislo() == poradoveCislo) {
                                this.dajFigurkuNaDosku(poradoveCislo);
                                // v pripade ze sa nasla figurka bolo potrebne osetrit dve situacie
                                // v situacii ze sa dala na dosku posledna figurka bola velkost zaciatocneho domceka 0
                                // preto sa spustala nasledujuca podmienka a zacala hladat figurku aj na hracej doske
                                if (this.zaciatocnyDomcek.isEmpty()) {
                                    i = -1; // nastavenie hodnoty i = -1 z dovodu
                                } else {
                                    i = 0;
                                }
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                    
                    // v pripade ze figurku s danym poradovym cislom nenaslo v zaciatocnom domceku
                    if (i == this.zaciatocnyDomcek.size()) {
                        int y = 0;
                        // hladanie na hracej doske
                        while (y < Hra.dajVelkostDosky()) {
                            Figurka pomFigurka = Hra.dajFigurkuNaPolicku(y);
                            if (pomFigurka != null) {
                                if (pomFigurka.getPoradoveCislo() == poradoveCislo && pomFigurka.getFarba().equals(this.farba)) {
                                    this.posunFigurkouPoDoske(poradoveCislo);
                                    y = 0;
                                
                                    break;
                                } else {
                                    y++;
                                }
                            } else {
                                y++;
                            }
                        }
                        
                        // na hracej doske figurku nenaslo, zacne hladat v konecnom domceku
                        if (y == Hra.dajVelkostDosky()) {
                            this.posunFigurkouVKonecnomDomceku(poradoveCislo);
                            
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Neplatny vstup!");
            }
        }
    }
    
    /**
     * po zadani cisla figurky odoberie figurku s danym cislom zo zaciatocneho domceka a presunie ju na hraciu dosku
     * musi byt splnena podmienka, ze na kocke padlo cislo 6
     * @param poradoveCislo je poradove cislo figurky
     */
    public void dajFigurkuNaDosku(int poradoveCislo) {
        
        int hodeneCislo = Hra.dajKocku().dajHodenuHodnotu();
        int i = 0;
                
        if (hodeneCislo == 6) {
                
            while (i < this.zaciatocnyDomcek.size()) {
                Figurka pomFigurka = this.zaciatocnyDomcek.get(i);
                if (pomFigurka.getPoradoveCislo() == poradoveCislo) {
                    this.zaciatocnyDomcek.remove(pomFigurka);
                    Hra.pridajFigurkuNaDosku(this.meno, pomFigurka);
                    i = 0;
                    this.zobrazZaciatocnyDomcek();
                    break;
                } else {
                    i++;
                }
            }
                
        } else {
            JOptionPane.showMessageDialog( null, "Nehodil si 6!");
        }
        
    }
    
    /**
     * posunie figurkou s danym poradovym cislom po hracej doske
     * @param poradoveCislo je poradoveCislo figurky
     */
    public void posunFigurkouPoDoske(int poradoveCislo) {
        int hodeneCislo = Hra.dajKocku().dajHodenuHodnotu();      
        Hra.posunFigurkouPoDoske(this.meno, poradoveCislo, hodeneCislo);
    }
    
    /**
     * @ return vrati boolean hodnotu na zaklade toho, ci sa da figurkou dostat na novu poziciu v konecnom domceku
     * metoda sa spusti v pripade, ze figurka s danym poradovym cislom sa nachadza v konecnom domceku alebo z hracej dosky sa ide dostat do konecneho domceku
     * @param poradoveCislo je poradove cislo figurky
     * @param oKolko je hodnota, o ktoru sa ma figurka posunut v konecnom domceku
     */
    public boolean posunFigurkouVKonecnomDomceku(int poradoveCislo, int oKolko) {
        int i = 0;
        boolean pomHodnota = false;
        Figurka pomFigurka = new Figurka(this.farba, poradoveCislo, i);
        // metoda zacne hladat figurku v konenckom domceku
        while (i < this.konecnyDomcek.length) {
            pomFigurka.setPozicia(i);
            if (this.konecnyDomcek[i] != null) {
                Figurka hladanaFigurka = this.konecnyDomcek[i];
                
                // v pripade ze ju najde
                if (pomFigurka.toString().equals(hladanaFigurka.toString())) {
                    int novaPozicia = oKolko + i;
                    if (novaPozicia < this.konecnyDomcek.length) {
                        if (this.konecnyDomcek[novaPozicia] == null) {
                            this.konecnyDomcek[i] = null;
                            hladanaFigurka.setPozicia(novaPozicia);
                            this.konecnyDomcek[novaPozicia] = hladanaFigurka;
                            pomHodnota = true;
                            i = 0;
                            break;
                        } else {
                            JOptionPane.showMessageDialog( null, "Na tejto pozicii uz mate figurku!");
                            pomHodnota = false;
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog( null, "Takyto tah nemozete spravit!");
                        pomHodnota = false;
                        break;
                    }
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        
        // metoda zisti, ze figurka s danym poradovym cislom sa nenachadza v konecnom domceku, tak ju tam prida
        if (i == this.konecnyDomcek.length) {
            int novaPozicia = oKolko;
            if (novaPozicia < this.konecnyDomcek.length) {
                if (this.konecnyDomcek[novaPozicia] == null) {
                    pomFigurka.setPozicia(novaPozicia);
                    this.konecnyDomcek[novaPozicia] = pomFigurka;
                    pomHodnota = true;
                } else {
                    JOptionPane.showMessageDialog( null, "Na tejto pozicii uz mate figurku!");
                    pomHodnota = false;
                }
            } else {
                JOptionPane.showMessageDialog( null, "Takyto tah nemozete spravit!");
                pomHodnota = false;
            }
        }
        
        return pomHodnota;
    }
    
    // pretazena metoda pre posunFigurkouVKonecnomDomceku
    /**
     * posunie figurkou v konecnom domceku
     * @param poradoveCislo je poradove cislo figurky
     */
    public void posunFigurkouVKonecnomDomceku(int poradoveCislo) {
        this.posunFigurkouVKonecnomDomceku(poradoveCislo, Hra.dajKocku().dajHodenuHodnotu());
        this.zobrazKonecnyDomcek();
    }
    
    

}
