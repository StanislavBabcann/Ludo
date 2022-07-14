

/**
  Vymenovacia trieda FarbaFigurky.
 * 
 * @author (Babcan)
 * @version (7.1.2021)
 */
public enum FarbaFigurky {
    MODRA("modra"),
    ZELENA("zelena"),
    CERVENA("cervena"),
    ZLTA("zlta");
    
    private String reprezentacia;
    
    /**
     * konstruktor vymenovacej triedy FarbaFigurky
     * @param paReprezentacia priradi atributu reprezentaciu vo forme retazcu String
     */
    FarbaFigurky(String paReprezentacia) {
        this.reprezentacia = paReprezentacia;
    }
    
    /**
     * @return vrati reprezentaciu atributu
     */
    public String getReprezentacia() {
        return this.reprezentacia;
    }
}
