package dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

public class Mendiak {
    // Class atributes
    List<Mendia> mendiak;

    // Getters and setters
    public List<Mendia> getMendiak() {
        return mendiak;
    }
    public void setMendiak(List<Mendia> mendiak) {
        this.mendiak = mendiak;
    }

    //Method for adding a new Mendia
    public void add( Mendia mendia )
    {
        if( this.mendiak == null )
        {
            this.mendiak = new ArrayList<Mendia>();
        }
        this.mendiak.add(mendia);
    }
}
