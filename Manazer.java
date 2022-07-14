import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

// tuto triedu mam zo systemu moodle predmetu Informatika 1 z projektu tvaryV3

/**
 * Automaticky posiela spravy danym objektom:<br />
 * posunDole() - pri stlaceni klavesy DOWN<br />
 * posunHore() - pri stlaceni klavesy UP<br />
 * posunVlavo() - pri stlacen klavesy LEFT<br />
 * posunVpravo() - pri stlaceni klavesy RIGHT<br />
 * aktivuj() - pri stlaceni klavesy ENTER alebo SPACE<br />
 * zrus() - pri stlaceni klavesy ESC<br />
 * tik() - kazdych 0,25 sekundy<br />
 * vyberSuradnice(x, y) - pri kliknuti mysou
 */
public class Manazer {
    private ArrayList<Object> spravovaneObjekty;
    private long oldTick;
    private static final long TICK_LENGTH = 250000000;
    
    private class ManazerKlaves extends KeyAdapter {
        /**
         * tuto triedu som upravil tak, aby priradila spravovanym objektom klaves, pomoocu ktoreho im mozno posielat spravy
         */
        public void keyPressed(KeyEvent event) {
            Kocka kocka = Hra.dajKocku();
            if (event.getKeyCode() == KeyEvent.VK_SPACE) {
                Manazer.this.posliSpravu("hodKockou", kocka);
            }
            
            for (int i = 0; i < Hra.getPocetHracov(); i++) {
                Hrac pomHrac = Hra.dajHraca(i);
                if (pomHrac.getFarba().equals("modra")) {
                    if (event.getKeyCode() == KeyEvent.VK_Y) {
                        Manazer.this.posliSpravu("zahrajFigurku", pomHrac);
                    } 
                } else if (pomHrac.getFarba().equals("zelena")) {
                    if (event.getKeyCode() == KeyEvent.VK_J) {
                        Manazer.this.posliSpravu("zahrajFigurku", pomHrac);
                    } 
                } else if (pomHrac.getFarba().equals("cervena")) {
                    if (event.getKeyCode() == KeyEvent.VK_Q) {
                        Manazer.this.posliSpravu("zahrajFigurku", pomHrac);
                    } 
                } else if (pomHrac.getFarba().equals("zlta")) {
                    if (event.getKeyCode() == KeyEvent.VK_P) {
                        Manazer.this.posliSpravu("zahrajFigurku", pomHrac);
                    } 
                }
            }
        }
    }
    
    private class ManazerCasovaca implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            long newTick = System.nanoTime();
            if (newTick - Manazer.this.oldTick >= Manazer.TICK_LENGTH || newTick < Manazer.TICK_LENGTH) {
                Manazer.this.oldTick = (newTick / Manazer.TICK_LENGTH) * Manazer.TICK_LENGTH;
                //Manazer.this.posliSpravu("tik");
            }
        }
    }
    
    private class ManazerMysi extends MouseAdapter {
        public void mouseClicked(MouseEvent event) {
            if (event.getButton() == MouseEvent.BUTTON1) {
                Manazer.this.posliSpravu("posunVpravo", event.getX(), event.getY());
            }
        }
    }
    
    private void posliSpravu(String selektor, Object adresat) {
        
        try {
            Method sprava = adresat.getClass().getMethod(selektor);
            sprava.invoke(adresat);
        } catch (SecurityException e) {
            this.doNothing();
        } catch (NoSuchMethodException e) {
            this.doNothing();
        } catch (IllegalArgumentException e) {
            this.doNothing();
        } catch (IllegalAccessException e) {
            this.doNothing();
        } catch (InvocationTargetException e) {
            this.doNothing();
        }
        
    }
    
    private void posliSpravu(String selektor, int prvyParameter, int druhyParameter) {
        for (Object adresat : this.spravovaneObjekty) {
            try {
                Method sprava = adresat.getClass().getMethod(selektor, Integer.TYPE, Integer.TYPE);
                sprava.invoke(adresat, prvyParameter, druhyParameter);
            } catch (SecurityException e) {
                this.doNothing();
            } catch (NoSuchMethodException e) {
                this.doNothing();
            } catch (IllegalArgumentException e) {
                this.doNothing();
            } catch (IllegalAccessException e) {
                this.doNothing();
            } catch (InvocationTargetException e) {
                this.doNothing();
            }
        }
    }
    
    private void doNothing() {
        
    }
    
    /**
     * Vytvori novy manazer, ktory nespravuje zatial ziadne objekty.
     */
    public Manazer() {
        this.spravovaneObjekty = new ArrayList<Object>();
        Platno.dajPlatno().addKeyListener(new ManazerKlaves());
        Platno.dajPlatno().addTimerListener(new ManazerCasovaca());
        Platno.dajPlatno().addMouseListener(new ManazerMysi());
    }
    
    /**
     * Manazer bude spravovat dany objekt.
     * 
     * tuto triedu som upravil tak, aby spravovala objekty, ktore su pridane v atribute hraci a v atribute kocka triedy Hra
     * 
     */
    public void spravujObjekt() {
        for (int i = 0; i < Hra.getPocetHracov(); i++) {
            Hrac pomHrac = Hra.dajHraca(i);
            this.spravovaneObjekty.add(pomHrac);
        }
        this.spravovaneObjekty.add(Hra.dajKocku());
    }
}
