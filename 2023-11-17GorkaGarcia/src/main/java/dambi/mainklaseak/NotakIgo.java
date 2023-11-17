package dambi.mainklaseak;


import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

/**
 * Datu-iturria: Notak.csv
 * Sortutako fitxategia: NotaHobetuak.xml
 * Programa honek nota guztiak puntu bat igoko ditu,
 * kontutan izanik notarik altuena 10 dela.
 * 
 */
public class NotakIgo {
  public static void main(String[] args) {
    int counter = 0;

    // Objektua irakurri CSV fitxategitik
    Csva csvFitxategia = new Csva("datuak/Notak.csv");
    Notak notak = csvFitxategia.irakurri();

    // Sortu Notak objektu berria, hobetutako nota berriak gehitezko
    Notak notaHobetuak = new Notak();

    // Nota bakoitzari puntu bat igo posible bada, eta objektu berrian gehitu
    for (Nota nota : notak.getNotak()){
        if(nota.getNota() <= 9){
            nota.setNota(nota.getNota() + 1);
        } else {
          nota.setNota(10);
        }
        notaHobetuak.add(nota);
        counter++;
    }

    // XML fitxategi berrian objektua idatzi/gorde
    System.out.println(counter + " nota idatzi dira xml fitxategian.");
    Xmla xmla = new Xmla("","datuak/NotaHobetuak.xml");
    xmla.idatzi(notaHobetuak);
  }
}