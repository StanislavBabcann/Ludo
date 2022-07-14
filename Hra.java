import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
  Trieda Hra
 *
 * @author (Babcan)
 * @version (7.1.2021)
 */
public class Hra {
    private static ArrayList<Hrac> hraci;
    private static Figurka[] hraciaDoska;
    private static Kocka kocka;
    private static Hra instancia;
    
    /**
     * konstruktor triedy Hra
     * inizializuje atributy triedy na dane hodnoty
     */
    public Hra() {
        this.hraciaDoska = new Figurka[40];
        this.hraci = new ArrayList<Hrac>(4);
        this.kocka = new Kocka();
        this.instancia = null;
    }
    
    // metody triedy
    /**
     * @ return vrati instanciu triedy
     */
    public static Hra getHra() {
        if (Hra.instancia == null) {
            Hra.instancia = new Hra();
        }
        return Hra.instancia;
    }
    
    /**
     * @return vrati velkost atributu Hra
     */
    public static int dajVelkostDosky() {
        return hraciaDoska.length;
    }
    
    /**
     * prida instanciu daneho hraca do atributu hraci
     */
    public static void pridajHraca(Hrac paHrac) {
        hraci.add(paHrac);
    }
    
    /**
     * @return vrati pocet hracov v atribute hraci
     */
    public static int getPocetHracov() {
        return hraci.size();
    }
    
    /**
     * @return vrati hraca na danej pozicii v atribute hraci
     * @param poradie je poradie hraca v atribute hraci
     */
    public static Hrac dajHraca(int poradie) {
        return hraci.get(poradie);
    }
    
    /**
     * @return vrati atribut kocka
     */
    public static Kocka dajKocku() {
        return kocka;
    }
    
    /**
     * @return vrati objekt figurky, ktora sa nachadza na danom policku
     * @param policko je prvok atributu hraciaDoska
     */
    public static Figurka dajFigurkuNaPolicku(int policko) {
        return hraciaDoska[policko];
    }
    
    /**
     * zobrazi hraciu dosku a figurky v nej na platne
     */
    public static void zobrazHraciuDosku() {
        for (int i = 0; i < hraciaDoska.length; i++) {
            Kruh pomKruh = null;
            
            if (hraciaDoska[i] != null) {
                pomKruh = hraciaDoska[i].getGrafickeZobrazenie();
            } else {
                pomKruh = dajKruh(i);
                if (i == 0) {
                    pomKruh.zmenFarbu("slaboModra");
                } else if (i == 10) {
                    pomKruh.zmenFarbu("slaboZelena");
                } else if (i == 20) {
                    pomKruh.zmenFarbu("slaboCervena");
                } else if (i == 30) {
                    pomKruh.zmenFarbu("slaboZlta");
                }
            }
                
            if (i < 5) {
                pomKruh.setSuradnice(750 , 100 + i * 30);
            } else if (i < 9 && i > 4) {
                pomKruh.setSuradnice(630 + i * 30, 220);
            } else if (i < 10 && i > 8) {
                pomKruh.setSuradnice(870, -20 + i * 30);
            } else if (i < 15 && i > 9) {
                pomKruh.setSuradnice(1170 - i * 30 , 280);
            } else if (i < 19 && i > 14) {
                pomKruh.setSuradnice(750, -140 + i * 30);
            } else if (i < 20 && i > 18) {
                pomKruh.setSuradnice(1290 - i * 30 , 400);
            } else if (i < 25 && i > 19) {
                pomKruh.setSuradnice(690 , 1000 - i * 30);
            } else if (i < 29 && i > 24) {
                pomKruh.setSuradnice(1410 - i * 30 , 280);
            } else if (i < 30 && i > 28) {
                pomKruh.setSuradnice(570 , 1120 - i * 30);
            } else if (i < 35 && i > 29) {
                pomKruh.setSuradnice(-330 + i * 30, 220);
            } else if (i < 39 && i > 34) {
                pomKruh.setSuradnice(690, 1240 - i * 30);
            } else if (i == 39) {
                pomKruh.setSuradnice(720, 100);
            }
            
            pomKruh.zobraz();
        }
        
        for (int i = 0; i < 8; i++) {
            Kruh pomKruhModry = new Kruh("slaboModra");
            Kruh pomKruhZeleny = new Kruh("slaboZelena");
            Kruh pomKruhCerveny = new Kruh("slaboCervena");
            Kruh pomKruhZlty = new Kruh("slaboZlta");
            
            if (i < 4) {
                pomKruhModry.setSuradnice(720, 130 + i * 30);
                pomKruhZeleny.setSuradnice(840 - i * 30, 250);
                pomKruhCerveny.setSuradnice(720, 370 - i * 30);
                pomKruhZlty.setSuradnice(600 + i * 30, 250);
           
            } else if (i == 4) {
                pomKruhModry.setSuradnice(840, 100);
                pomKruhZeleny.setSuradnice(840, 370);
                pomKruhCerveny.setSuradnice(570, 370);
                pomKruhZlty.setSuradnice(570, 100);
                
            } else if (i == 5) {
                pomKruhModry.setSuradnice(870, 100);
                pomKruhZeleny.setSuradnice(870, 370);
                pomKruhCerveny.setSuradnice(600, 370);
                pomKruhZlty.setSuradnice(600, 100);
                
            } else if (i == 6) {
                pomKruhModry.setSuradnice(840, 130);
                pomKruhZeleny.setSuradnice(840, 400);
                pomKruhCerveny.setSuradnice(570, 400);
                pomKruhZlty.setSuradnice(570, 130);
                
            } else if (i == 7) {
                pomKruhModry.setSuradnice(870, 130);
                pomKruhZeleny.setSuradnice(870, 400);
                pomKruhCerveny.setSuradnice(600, 400);
                pomKruhZlty.setSuradnice(600, 130);
                
            }
            
            pomKruhModry.zobraz();
            pomKruhZeleny.zobraz();
            pomKruhCerveny.zobraz();
            pomKruhZlty.zobraz();
        }
        
        for (int i = 0; i < hraci.size(); i++) {
            Hrac pomHrac = hraci.get(i);
            pomHrac.zobrazZaciatocnyDomcek();
            pomHrac.zobrazKonecnyDomcek();
        }
        
        kocka.zobrazKocku();
    }
    
    /**
     * prida figurku od instancie triedy Hrac na hraciu dosku,v pripade, ze to je mozne podla pravidiel
     * zaciatocna pozicia figurky sa urcuje podla atributu farba instancie triedy Hrac
     * @param paMeno je atribut meno instanice triedy Hrac
     * @param paFigurka je figurka z atributu zaciatocnyDomcek instancie triedy Hrac
     */
    public static void pridajFigurkuNaDosku(String paMeno, Figurka paFigurka) {
        for (int i = 0; i < hraci.size(); i++) {
            String pomMeno = hraci.get(i).getMeno();
            if (pomMeno.equals(paMeno)) {
                String farba = hraci.get(i).getFarba();
                int startovnaPozicia = 0;
                
                // kazdy hrac musi startovat na inom policku na hracej doske
                if (farba.equals("modra")) {
                    startovnaPozicia = 0;
                } else if (farba.equals("zelena")) {
                    startovnaPozicia = 10;
                } else if (farba.equals("cervena")) {
                    startovnaPozicia = 20;
                } else if (farba.equals("zlta")) {
                    startovnaPozicia = 30;
                }
                
                // v pripade ze startovne policko je prazdne
                if (hraciaDoska[startovnaPozicia] == null) {
                    paFigurka.setPozicia(startovnaPozicia);
                    hraciaDoska[startovnaPozicia] = paFigurka;
                // na startovnom policku sa nasla figurka
                } else {
                    Figurka figurkaNaStartovejPozicii = hraciaDoska[startovnaPozicia];
                    String farbaFigurkyNaStartovejPozicii = figurkaNaStartovejPozicii.getFarba();
                    // figurka na startovnom policku bola tej istej farby, preto mu figurku co chcel dat na dosku vrati spat do zaciatocneho domceka
                    if (farbaFigurkyNaStartovejPozicii.equals(farba)) {
                        hraci.get(i).dajFigurkuDoZaciatocnehoDomceka(paFigurka);
                        JOptionPane.showMessageDialog( null, "Tato pozicia je uz obsadena vasou inou figurkou!");
                    // naslo figurku inej farby
                    } else {         
                        for (int k = 0; k < hraci.size(); k++) {
                            Hrac vyhodenyHrac = hraci.get(k);
                            // zisti ktoremu hracovi patri dana figurka
                            if (vyhodenyHrac.getFarba().equals(farbaFigurkyNaStartovejPozicii)) {
                                // vrati mu figurku a da svoju figurku na dosku
                                vyhodenyHrac.dajFigurkuDoZaciatocnehoDomceka(figurkaNaStartovejPozicii);
                                hraciaDoska[startovnaPozicia] = null;
                                pridajFigurkuNaDosku(paMeno, paFigurka);
                            } 
                                    
                        }
                    }
                }
            }
        }
        zobrazHraciuDosku();
    }
    
    /**
     * posunie figurkou v atribute hraciaDoska v pripade, ze to je mozne podla pravidiel
     * v pripade, ze by figurka mala ist z dosky do konecneho domceka spusti na to pripravenu metodu v instancii triedy Hrac
     * @param paMeno je atribut meno instancie triedy Hrac
     * @param poradoveCisloFigurky je poradove cislo figurky
     * @param hodeneCislo je hodnota ktora bola hodena na kocke
     */
    public static void posunFigurkouPoDoske(String paMeno, int poradoveCisloFigurky, int hodeneCislo) {
        Hrac pomHrac = null;
        for (int i = 0; i < hraci.size(); i++) {
            String pomMeno = hraci.get(i).getMeno();
            
            if (pomMeno.equals(paMeno)) {
                String pomFarba = hraci.get(i).getFarba();
                pomHrac = hraci.get(i);
                int y = 0;
                
                // zacne hladat poziciu kde sa dana figurka nachadza
                while (y < hraciaDoska.length) {
                    Figurka pomFigurka = new Figurka(pomFarba, poradoveCisloFigurky, y);
                    Figurka hladanaFigurka = hraciaDoska[y];
                    
                    if (hladanaFigurka != null) {
                        // v pripade ze ju naslo
                        if (pomFigurka.toString().equals(hladanaFigurka.toString())) {
                            // vytvorenie novej pozicie figurky
                            int pomPozicia = y + hodeneCislo;
                            
                            // v pripade ze by figurka mala presiahnut velkost pola a nebola by modra, vytvori novu poziciu od zaciatku pola
                            if (pomPozicia > 39 && (!pomFarba.equals("modra"))) {
                                pomPozicia = pomPozicia - hraciaDoska.length;
                            }
                            
                            int posunVKonecnomDomceku = 0;
                            
                            // nasledujuce vetvy riesia situaciu ze by figurka mala ist z hracej dosky do svojho konecneho domceka
                            // splni sa v pripade ze by sa figurka mala dostat za svoju startovu poziciu alebo na nu
                            // treba taktiez skontrolovat ci startuje z takej pozicie ze po hodeni kockou by sa na taku poziciu mohla dostat
                            if (pomPozicia > 39 && pomFarba.equals("modra") && y > 33) {
                                posunVKonecnomDomceku = pomPozicia - hraciaDoska.length;
                                
                                if (pomHrac.posunFigurkouVKonecnomDomceku(poradoveCisloFigurky, posunVKonecnomDomceku) ) {
                                    hraciaDoska[y] = null;
                                    
                                }
                            } else if (pomPozicia > 9 && pomFarba.equals("zelena") && y < 10) {
                                posunVKonecnomDomceku = pomPozicia - 10;
                                
                                if (pomHrac.posunFigurkouVKonecnomDomceku(poradoveCisloFigurky, posunVKonecnomDomceku) ) {
                                    hraciaDoska[y] = null;
                                    
                                }
                            } else if (pomPozicia > 19 && pomFarba.equals("cervena") && y < 20) {
                                posunVKonecnomDomceku = pomPozicia - 20;
                                
                                if (pomHrac.posunFigurkouVKonecnomDomceku(poradoveCisloFigurky, posunVKonecnomDomceku) ) {
                                    hraciaDoska[y] = null;
                                   
                                }
                            } else if (pomPozicia > 29 && pomFarba.equals("zlta") && y < 30) {
                                posunVKonecnomDomceku = pomPozicia - 30;
                                
                                if (pomHrac.posunFigurkouVKonecnomDomceku(poradoveCisloFigurky, posunVKonecnomDomceku) ) {
                                    hraciaDoska[y] = null;
                                    
                                }
                                // v pripade ze dana pozicia je prazdna
                            } else if (hraciaDoska[pomPozicia] == null) {
                                hladanaFigurka.setPozicia(pomPozicia);
                                hraciaDoska[pomPozicia] = hladanaFigurka;
                                hraciaDoska[y] = null;
                                hladanaFigurka.setPozicia(pomPozicia);
                                
                            } else {
                                // na danej pozicii bola zistena dalsia figurka
                                Figurka figurkaNaPomPozicii = hraciaDoska[pomPozicia];
                                String farbaFigurkyNaPomPozicii = figurkaNaPomPozicii.getFarba();
                                
                                if (farbaFigurkyNaPomPozicii.equals(pomFarba)) {
                                    JOptionPane.showMessageDialog( null, "Tato pozicia je uz obsadena vasou inou figurkou!");
                                    
                                } else {
                                    for (int k = 0; k < hraci.size(); k++) {
                                        Hrac vyhodenyHrac = hraci.get(k);
                                        if (vyhodenyHrac.getFarba().equals(farbaFigurkyNaPomPozicii)) {
                                            
                                            vyhodenyHrac.dajFigurkuDoZaciatocnehoDomceka(figurkaNaPomPozicii);
                                            hraciaDoska[pomPozicia] = null;
                                            posunFigurkouPoDoske(paMeno, poradoveCisloFigurky, hodeneCislo);
                                        } 
                                            
                                    }
                                }
                            }
                            break;
                        } else {
                            y++;
                            
                        }
                    } else {
                        y++;
                        
                    }
                }
            }
        }
        zobrazHraciuDosku();
        // posledny krok co urobi kazdy hrac je ze posunie svojou poslednou figurkou z hracej dosky do konecneho domceka
        // tato podmienka sa spusti len raz pre kazdeho hraca kedze po naplneni konecneho domceku uz hrac nema dovolene robit ziadne tahy
        // tymto sposobom som zabezpecil aby sa do vyhodnotenia zapisalo kazde meno len raz
        if (pomHrac.skontrolujKonecnyDomcek()) {
            VyhodnotenieHry.priradMiesto(paMeno);
            
        }
    }
    
    /**
     * @return vrati na prislusnu poziciu atributu hraciaDoska instanciu triedy Kruh
     * @param poziciaNaDoske je prvok atributu hraciaDoska
     */
    private static Kruh dajKruh(int poziciaNaDoske) {
        Figurka pomFigurka = hraciaDoska[poziciaNaDoske];
        Kruh pomKruh = null;
        if (pomFigurka != null) {
            pomKruh = hraciaDoska[poziciaNaDoske].getGrafickeZobrazenie(); 
            
        } else {
            pomKruh = new Kruh("seda");
            
        }
        return pomKruh;
    }
}
