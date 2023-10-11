package dambi.atzipenekoak;

import dambi.pojoak.Mendiak;

public abstract class FitxategiAtzipena {
    
    // Class atributes
    String strFileIn;
    String strFileOut;

    // Class constructors
    public FitxategiAtzipena(String strFileIn) {
        this.strFileIn = strFileIn;
    }
    public FitxategiAtzipena(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    // Class methods
    public abstract Mendiak irakurri();
    public abstract void idatzi(Mendiak mendiak);
}
