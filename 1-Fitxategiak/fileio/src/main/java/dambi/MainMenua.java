package main.java.dambi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainMenua {
    public static String FITXATEGIA = "Mendiak.csv";

    /**This method is the main menu of the program */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENUAREN IZENBURUA");
            System.out.println("====================================");
            System.out.println("1.- Fitxategi/Direktoria existitzen den egiaztatu.");
            System.out.println("2.- Direktorio baten edukia erakutsi.");
            System.out.println("3.- Direktorio egitura sortu.");
            System.out.println("4.- Fitxategia sortu.");
            // System.out.println("4.- ...");
            System.out.println("5.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    pathAbsolutuaBilatu();
                    break;
                case 2:
                    edukiaIkusi();
                    break;
                case 3:
                    direktorioakSortu();
                    break;
                case 4:
                    fitxategiaSortu();
                    break;
                case 5:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
    }

    /** Erabiltzaileari fitxategi/direktorio baten path absolutoa eskatu eta gure fitxategi sisteman ba ote daukagun egiaztatu behar du funtzio honek */
    public static void pathAbsolutuaBilatu(){
    }

    /** Direktorio zehatz baten lehen mailako edukia erakutsi behar du funtzio honek */
    public static void edukiaIkusi(){
        
    }

    /**Hurrengo karpeta egitura sortu behar du funtzio honek:
    karpeta_berriak
        ├── animaliak
        │   ├── arrainak
        │   └── ugaztunak
        └── elikagaiak
        ├── barazkiak
        └── esnekiak
    */
    public static void direktorioakSortu(){
        
    }

    /** Galdera batzuk egin ondoren, fitxategi bat sortu behar du leku egokian */
    public static void fitxategiaSortu(){
        
    }

}

