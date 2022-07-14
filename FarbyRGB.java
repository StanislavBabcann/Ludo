import java.awt.Color;
/**
  Trieda FarbyRGB.
  
 * @author (Babcan)
 * @version (7.1.2021)
 */
public class FarbyRGB {
    //konstantne atributy triedy
    
    /**
     * v konstantnych atributoch som si vytvoril nove farby a zakladne farby s inym odtienom, ktore som potreboval pouzit v triede Platno
     * ako vytvorit nove farby som zistil na stranke teaching.csse.uwa (https://teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html)
     */
    
    private static final Color VERY_LIGHT_BLUE = new Color(51, 204, 255);
    private static final Color VERY_LIGHT_GREEN = new Color(181, 245, 181);
    private static final Color VERY_LIGHT_YELLOW = new Color(255, 255, 185);
    private static final Color VERY_LIGHT_RED = new Color(255, 102, 102);
    private static final Color LIGHT_BROWN = new Color(153, 102, 0);
    private static final Color GREY = new Color(153, 153, 153);
    private static final Color LIGHT_GREY = new Color(204, 204, 204);
    
    /**
     * @return vrati prislusnu farbu podla zadaneho retazcu String
     * @param farba priradi k retazcu String prislusnu farbu
     */
    public static Color getFarba(String farba) {
        Color color = null;
        if (farba.equals("slaboModra")) {
            color = VERY_LIGHT_BLUE;
        } else if (farba.equals("slaboZelena")) {
            color = VERY_LIGHT_GREEN;
        } else if (farba.equals("slaboZlta")) {
            color = VERY_LIGHT_YELLOW;
        } else if (farba.equals("slaboCervena")) {
            color = VERY_LIGHT_RED;
        } else if (farba.equals("slaboHneda")) {
            color = LIGHT_BROWN;
        } else if (farba.equals("seda")) {
            color = GREY;
        } else if (farba.equals("slaboSeda")) {
            color = LIGHT_GREY;
        }
        return color;
        
    }
}
