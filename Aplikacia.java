import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
  Trieda Aplikacia.
 *
 * @author (Babcan)
 * @version (7.1.2021)
 */

public class Aplikacia {
    
    /**
     * metoda main
     * po spusteni zobrazi okno, v ktorom sa zada pocet hracov
     * nasledne zobrazi dalsie okno, v ktorom si hraci zvolia mena a farby
     * ako vytvorit okno s moznostou zadania viacerych udajov som zistil na stranke java2s.com (//http://www.java2s.com/Tutorials/Java/Swing_How_to/JOptionPane/Create_Multiple_input_in_JOptionPane_showInputDialog.htm)
     * v pripade, ze zadane udaje su korektne, vytvoria sa nove instancie triedy Hrac a pridaju sa do triedy Hra
     */
    public static void main() {
        JPanel panel = new JPanel();
        JTextField pocet = new JTextField(5);
        panel.add(pocet);
        panel.setLayout(new GridLayout(1, 0, 1, 1));
        
        int potvrdenie = JOptionPane.showConfirmDialog(null, panel, "Zadajte pocet hracov v rozsahu 1 - 4 :", JOptionPane.OK_CANCEL_OPTION);
        if (potvrdenie == JOptionPane.OK_OPTION) {
            String vstup = pocet.getText();
            if (Aplikacia.kontrolaVstupu(vstup)) {
                int pocetHracov = Integer.parseInt(vstup);
                if (pocetHracov > 4 || pocetHracov < 1) {
                    JOptionPane.showMessageDialog(null, "Pocet hracov moze byt len v rozsahu 1 - 4!");
                
                } else {
                
                    JTextField[] menaHracovText = new JTextField[pocetHracov];
                    JTextField[] farbyHracovText = new JTextField[pocetHracov];
                
                    JPanel pane = new JPanel();
                    
                    // pre kazdeho hraca vytvori policko pre meno a farbu a ulozi ich do daneho pola
                    for (int i = 0; i < pocetHracov; i++) {
                        menaHracovText[i] = new JTextField(5);
                        farbyHracovText[i] = new JTextField(5);
                        pane.add(new JLabel("Meno hraca: "));
                        pane.add(menaHracovText[i]);
                        pane.add(new JLabel("Farba hraca: "));
                        pane.add(farbyHracovText[i]);
                 
                        pane.setLayout(new GridLayout(i * 2 + 2, 2, 2, 2));
                        pane.setPreferredSize(new Dimension(300, i * 40 + 40));
                    }
                    
                    int vysledok = JOptionPane.showConfirmDialog(null, pane, ("Zadajte mena hracov a farby(modra, zelena, cervena, zlta) :"), JOptionPane.OK_CANCEL_OPTION);
                    
                    String vypisOvladania = "";
                
                    if (vysledok == JOptionPane.OK_OPTION) {
                        Hra hra = Hra.getHra();
                        // dostane meno a farbu hraca z pola a vytvori jeho instanciu
                        for (int i = 0; i < pocetHracov; i++) {
                            String meno = menaHracovText[i].getText();
                            String farba = farbyHracovText[i].getText();
                            FarbaFigurky farbaFigurky = null;
                            boolean kontrolaFarby = true;
                            
                            String ovladanie = null;
                            
                            // do parametru ovladanie pre kazdu farbu ulozi pokyny pre ovladanie danej farby pri prechode cyklu
                            if (farba.equals("modra")) {
                                farbaFigurky = FarbaFigurky.MODRA;
                                ovladanie = "modra: Y ,";
                            } else if (farba.equals("zelena")) {
                                farbaFigurky = FarbaFigurky.ZELENA;
                                ovladanie = "zelena: J ,";
                            } else if (farba.equals("cervena")) {
                                farbaFigurky = FarbaFigurky.CERVENA;
                                ovladanie = "cervena: Q ,";
                            } else if (farba.equals("zlta")) {
                                farbaFigurky = FarbaFigurky.ZLTA;
                                ovladanie = "zlta: P ,";
                            } else {
                                JOptionPane.showMessageDialog(null, "Neplatna farba!");
                                kontrolaFarby = false;
                            }
                            
                            // v pripade neplatnej farby nevytvori instanciu hraca
                            if (kontrolaFarby) {
                                vypisOvladania = vypisOvladania + ovladanie;
                                Hrac hrac = new Hrac(meno, farbaFigurky);
                                Hra.pridajHraca(hrac);
                            } 
                        }
                        
                        VyhodnotenieHry vyhodnotenie = new VyhodnotenieHry();
                        Manazer manazer = new Manazer();
                        JOptionPane.showMessageDialog(null, "Ovladanie figurok: " + vypisOvladania + " hod kockou: medzernik.");
                        JOptionPane.showMessageDialog(null, "Figurky maju cisla od 1 po 4, klavesou pre danu farbu spustite okno, kde zadate cislo figurky a nasledne sa vykona posun figurky. Pamatejte si, ktora figurka ma ake cislo.");
                        hra.zobrazHraciuDosku();
                    } 
                }
            } else {
                JOptionPane.showMessageDialog(null, "Neplatny vstup!");
                
            }
        }
    }
    
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
    
}
