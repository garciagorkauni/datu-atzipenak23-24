package dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "Notak")
public class Notak {

    List<Nota> notak;

    public List<Nota> getNotak() {
        return notak;
    }

    @XmlElement( name = "Nota" )
    public void setNotak(List<Nota> notak) {
        this.notak = notak;
    }

    public void add(Nota nota) {
        if (this.notak == null) {
            this.notak = new ArrayList<Nota>();
        }
        this.notak.add(nota);

    }

    /**
     * Hau da erabili dezakezun algoritmoetako bat:
     * Zera errepikatu noten zerrenda hutsik egon arte:
     * - Noten zerrendako "lehen" ikaslea hartu, bere datuak hasieratuz (batura, kontadorea)
     *   eta zerrenda errebisatu atzenerarte bere noten bila. 
     * - Bere nota bat aurkitutakoan batu, zenbatu eta aurkitutako nota ezabatu egingo dugu traba egin ez dezan
     * - Azken notara heltzerakoan, ikasleen zerrendan gehitu eta berriz hasi.
     * 
     */
    public Ikasleak getIkasleenBB() {
        // Beharko diren aldagaiak sortu
        Ikasleak ikasleak = new Ikasleak();
        ArrayList<String> ikasleIzenak = new ArrayList<>();

        // Gorde Notak objektuan erregistrauta dauden ikasle guztien izenak
        // Aurretik sortutako metodoarekin, haun BB-a gorde sortu dugun Ikasleak objektuan
        for (Nota nota : notak) {
            boolean isSaved = false;
            for(int i = 0; i < ikasleIzenak.size(); i++){
                if (nota.getIkaslea().equals(ikasleIzenak.get(i))){
                    isSaved = true;
                }
            }
            if(!isSaved){
                ikasleIzenak.add(nota.getIkaslea());
            }
        }
        
        for(String ikasleIzena : ikasleIzenak){
            ikasleak.add(this.getIkaslearenBB(ikasleIzena));
        }
        
        return ikasleak;
    }

    /**
     * Ikasle baten nota guztien batezbestekoa kalkulatzen du.
     * 
     * @param ikaslea Adibidez, madariaga.idoia
     * @return Ikaslea motako objektu bat, atributo bezala batezbestekoa kalkulatuta
     *         daukana.
     */
    public Ikaslea getIkaslearenBB(String strIkaslea) {
        double guztira = 0;// ikasleari dagozkion noten batura joango gara gehitzen hemen
        double notaKopurua = 0;// ikasle honi dagazkion nota kopurua joango gara kontatzen hemen
        for (Nota n : notak) {
            if (n.getIkaslea().equals(strIkaslea)) {
                guztira += n.getNota();
                notaKopurua++;
            }
        }
        return new Ikaslea(strIkaslea, guztira / notaKopurua);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Nota n : this.notak) {
            str.append(n.toString());
            str.append("\n");
        }
        return str.toString();
    }

}
