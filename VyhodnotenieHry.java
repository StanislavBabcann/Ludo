import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
  Trieda VyhodnotenieHry.
 * 
 * @author (Babcan)
 * @version (7.1.2021)
 */

public class VyhodnotenieHry {
    private static String[] poradieHracov;
    
    /**
     * konstruktor triedy VyhodnotenieHry
     * inicializuje atribut triedy na danu hodnotu
     */
    public VyhodnotenieHry() {
        poradieHracov = new String [Hra.getPocetHracov()];
    }
    
    /**
     * priradi danemu hracovi miesto v poradii
     * @param meno je meno hraca
     */
    public static void priradMiesto(String meno) {
        int i = 0;
        
        while ( i < poradieHracov.length) {
            if (poradieHracov[i] == null) {
                poradieHracov[i] = meno;
                i++;
                break;
            } else {
                i++;
            }
            
        }
        
        if (i == Hra.getPocetHracov()) {
            VyhodnotenieHry.vypisVyhodnotenie();
        }
        
    }
    
    /**
     * po dokonceni hry zobrazi na obrazovke okno s poradim hracov
     */
    public static void vypisVyhodnotenie() {
        JPanel pane = new JPanel();
        
        for (int i = 0; i < poradieHracov.length; i++) {
            String pomMeno = poradieHracov[i];
            if (i == 0) {
                pane.add(new JLabel("Prve miesto  : " + pomMeno));
                
            }
            
            if (i == 1) {
                pane.add(new JLabel("Druhe miesto : " + pomMeno));
                
            }
            
            if (i == 2) {
                pane.add(new JLabel("Tretie miesto: " + pomMeno));
            }
            
            if (i == 3) {
                pane.add(new JLabel("Stvrte miesto: " + pomMeno));
            }
            
            pane.setLayout(new GridLayout(i + 1, 1, 0, 2));
        }
        
        JOptionPane.showMessageDialog(null, pane);
        
    }
   
}
