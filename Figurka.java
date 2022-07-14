/**
  Trieda Figurka.
 * 
 * @author (Babcan)
 * @version (7.1.2021)
 */
public class Figurka {
    // atributy instancie
    private String farba;
    private int poradoveCislo;
    private int poziciaFigurky;
    private Kruh grafickeZobrazenie; 
    
    /**
     * konstruktor triedy Figurka s parametrami - vytvori figurku s danymi parametrami
     * @param paFarba je farba figurky
     * @param paPoradoveCislo je poradove cislo figurky
     * @param paPoziciaFigurky je pozicia, na ktorej sa bude figurka nachadzat
     */
    public Figurka(String paFarba, int paPoradoveCislo, int paPoziciaFigurky) {
        this.farba = paFarba;
        this.poradoveCislo = paPoradoveCislo;
        this.poziciaFigurky = paPoziciaFigurky;
        
        switch (this.farba) {
            case "modra" : this.grafickeZobrazenie = new Kruh("blue");
                           break;
            case "zelena" : this.grafickeZobrazenie = new Kruh("green");
                            break;
            case "cervena" : this.grafickeZobrazenie = new Kruh("red");
                             break;
            case "zlta" : this.grafickeZobrazenie = new Kruh("yellow");
                          break;
        }
    }
    
    //metody instancie
    /**
     * @return vrati poradove cislo figurky
     */
    public int getPoradoveCislo() {
        return this.poradoveCislo;
    }
    
    /**
     * @return vrati farbu figurky
     */
    public String getFarba() {
        return this.farba;
    }
    
    /**
     * @return vrati poziciu figurky
     */
    public int getPozicia() {
        return this.poziciaFigurky;
    }
    
    /**
     * nastavi atribut poziciaFigurky na novu hodnotu
     * @param paPozicia je nova hodnota pre atribut poziciaFigurky
     */
    public void setPozicia(int paPozicia) {
        this.poziciaFigurky = paPozicia;
    }
    
    /**
     *@return vrati atributy farba, poradoveCislo, poziciaFigurky v formate String
     */
    public String toString() {
        return this.farba + ", " + this.poradoveCislo + ", " + this.poziciaFigurky; 
    }
    
    /**
     *@return vrati atribut grafickeZobrazenie
     */
    public Kruh getGrafickeZobrazenie() {
        return this.grafickeZobrazenie;
    }
     
   
   
   

}
