package dambi.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Scanner;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class JsonNotak {

    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public JsonNotak(String strFile) {
        strFileIn = strFile;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public JsonNotak(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }


    public Notak irakurri() {
        // Sortu beharko diren objektuak
        Notak notak = new Notak();
        JsonReader jsonReader;
        JsonArray jsonArray;
        
        // JSON fitxategia irakurri
        try {
            jsonReader = Json.createReader(new FileReader(strFileIn));
            jsonArray = jsonReader.readArray();

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.getJsonObject(i);
                // Objektuaren konstruktorea definitu dut bere klasean, kodigoa horrela erabiltzeko
                Nota nota = new Nota(
                                jsonObject.getInt("id"),
                                jsonObject.getString("ikaslea"),
                                LocalDate.parse(jsonObject.getString("data")),
                                jsonObject.getString("ikasgaia"),
                                jsonObject.getJsonNumber("nota").doubleValue());
                notak.add(nota);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }       

        return notak;
    }
}
