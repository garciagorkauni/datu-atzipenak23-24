package dambi.pojoak;

public class Mendia {

    // Class atributes
    int id;
    String mendia;
    int altuera;
    String probintzia;

    // Class constructors
    public Mendia() {
    }
    public Mendia(int id, String mendia, int altuera, String probintzia) {
        this.id = id;
        this.mendia = mendia;
        this.altuera = altuera;
        this.probintzia = probintzia;
    }

    // ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //MENDIA
    public String getMendia() {
        return mendia;
    }
    public void setMendia(String mendia) {
        this.mendia = mendia;
    }

    //ALTUERA
    public int getAltuera() {
        return altuera;
    }
    public void setAltuera(int altuera) {
        this.altuera = altuera;
    }

    //PROBINTZIA
    public String getProbintzia() {
        return probintzia;
    }
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }
}
