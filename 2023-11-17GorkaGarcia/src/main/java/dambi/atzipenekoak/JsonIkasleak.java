package dambi.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import dambi.pojoak.Ikaslea;
import dambi.pojoak.Ikasleak;
import dambi.pojoak.Notak;


public class JsonIkasleak {

    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public JsonIkasleak(String strFile) {
        strFileIn = strFile;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public JsonIkasleak(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public int idatzi(Ikasleak ikasleak) {
        // Sortu JsonArrayBuilder objetua, objektuak hor gordetzeko
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        // Ikasleak objektuaren ikasle bakoitza sartu array builder-ean
        for (Ikaslea ikaslea : ikasleak.getIkasleak()) {
            JsonObject jsonProduktua = Json.createObjectBuilder()
                .add("ikaslea", ikaslea.getIkaslea())
                .add("batezbestekoa", ikaslea.getBatezbestekoa())
                .build();

            jsonArrayBuilder.add(jsonProduktua);
        }

        // Json array-a eraiki
        JsonArray productArray = jsonArrayBuilder.build();

        // Fitxategian idatzi pasatutako datuak
        StringWriter stringWriter = new StringWriter();
        Json.createWriter(stringWriter).writeArray(productArray);
        String jsonString = stringWriter.toString();

        try {
            FileWriter fileWriter = new FileWriter(strFileOut);
            fileWriter.write(jsonString);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * ADI: Notak objetu bat jasotzen du metodo honek
     * @param notak
     * @return
     */
    public int idatzi(Notak notak) {
        // Beharko diren aldagaiak sortu
        Ikasleak ikasleak = new Ikasleak();
        ikasleak = notak.getIkasleenBB();
        int counter = 0;
        
        // Sortu JsonArrayBuilder objetua, objektuak hor gordetzeko
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        // Ikasleak objektuaren ikasle bakoitza sartu array builder-ean
        for (Ikaslea ikaslea : ikasleak.getIkasleak()) {
            JsonObject jsonProduktua = Json.createObjectBuilder()
                .add("ikaslea", ikaslea.getIkaslea())
                .add("batezbestekoa", ikaslea.getBatezbestekoa())
                .build();

            jsonArrayBuilder.add(jsonProduktua);
            counter++;
        }

        // Json array-a eraiki
        JsonArray productArray = jsonArrayBuilder.build();

        // Fitxategian idatzi pasatutako datuak
        StringWriter stringWriter = new StringWriter();
        Json.createWriter(stringWriter).writeArray(productArray);
        String jsonString = stringWriter.toString();

        try {
            FileWriter fileWriter = new FileWriter(strFileOut);
            fileWriter.write(jsonString);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return counter;

    }
}
