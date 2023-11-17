package dambi.pojoak;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

// XML-aren ordena definitu horrela bistaratzeko xml fitxategian
@XmlType( propOrder = { "id", "data", "ikaslea", "ikasgaia", "nota" } )
// Root elementua definitu
@XmlRootElement( name = "Nota" )

public class Nota {

    // Setter-etan, xml elementua edo atributua definitu.
    int id = 0;
    String ikaslea;
    LocalDate data;
    String ikasgaia;
    double nota;

    public int getId(){
        return id;
    }

    // Atribute bezala definitu, argiago ikusteko, elementuaren gakoa dela
    @XmlAttribute (name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getIkaslea() {
        return ikaslea;
    }

    @XmlElement (name = "Ikaslea")
    public void setIkaslea(String ikaslea) {
        this.ikaslea = ikaslea;
    }

    public String getData() {
        return data.toString();
    }

    @XmlElement (name = "Data")
    public void setData(String data) {
        this.data = LocalDate.parse(data);
    }

    public String getIkasgaia() {
        return ikasgaia;
    }

    @XmlElement (name = "Ikasgaia")
    public void setIkasgaia(String ikasgaia) {
        this.ikasgaia = ikasgaia;
    }

    public double getNota() {
        return nota;
    }

    @XmlElement (name = "Emaitza")
    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nota["+ id+", "+ikaslea+", "+data+", "+ikasgaia+", "+nota+"]";
    }

    // Class constructor
    public Nota(int id, String ikaslea, LocalDate data, String ikasgaia, double nota) {
        this.id = id;
        this.ikaslea = ikaslea;
        this.data = data;
        this.ikasgaia = ikasgaia;
        this.nota = nota;
    }

    public Nota() {
    }
}
