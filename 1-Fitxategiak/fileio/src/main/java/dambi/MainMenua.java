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
        // Scanner objektua sortu
        Scanner scanner = new Scanner(System.in);

        // Erabiltzaileari path absolutoa eskatu
        System.out.println("Sartu fitxategi/direktorioaren path absolutoa: ");
        String pathAbsoluto = scanner.next();

        // File objektua sortu path absolutoarekin
        File fitxategia = new File(pathAbsoluto);

        // Egiaztatu fitxategi/direktorioa existitzen al da
        if (fitxategia.exists()) {
            if (fitxategia.isFile()) {
                System.out.println("Fitxategia existitzen da.");
            } else if (fitxategia.isDirectory()) {
                System.out.println("Direktorioa existitzen da.");
            }
        } else {
            System.out.println("Fitxategia edo direktorio hori ez da aurkitzen sisteman.");
        }

        // Scanner objektua itxi
        scanner.close();
    }

    /** Direktorio zehatz baten lehen mailako edukia erakutsi behar du funtzio honek */
    public static void edukiaIkusi(){
        // Scanner objektua sortu
        Scanner scanner = new Scanner(System.in);

        // Karpeta baten path absolutoa eskatu erabiltzaileari
        System.out.println("Sartu karpetaaren path absolutoa: ");
        String karpetaPath = scanner.next();

        // File objektua sortu karpetaPath erabiliz
        File karpeta = new File(karpetaPath);

        // Egiaztatu karpeta existitzen dela
        if (karpeta.exists() && karpeta.isDirectory()) {
            // Karpeta existitzen da, egiaztatu fitxategiak daudela
            File[] fitxategiak = karpeta.listFiles();

            if (fitxategiak != null && fitxategiak.length > 0) {
                System.out.println(karpetaPath + " karpetaren edukia:");
                for (File fitxategia : fitxategiak) {
                    if (fitxategia.isFile()) {
                        System.out.println("|- " + fitxategia.getName());
                    } else if (fitxategia.isDirectory()) {
                        System.out.println("|- " + fitxategia.getName() + "/");
                    }
                }
            } else {
                System.out.println("Karpeta hutsik dago.");
            }
        } else {
            System.out.println("Karpeta hori ez da aurkitzen sisteman.");
        }

        // Scanner objektua itxi
        scanner.close();
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
        // Scanner objektua sortu
        Scanner scanner = new Scanner(System.in);

        try {
            // Karpetaren izena eskatu eta sortu path-a




            // Fitxategiaren izena eskatu erabiltzaileari
            System.out.println("Zein? ");
            String izena = scanner.next();
            izena += ".txt"

            // Fitxategiaren edukia eskatu erabiltzaileari
            System.out.println("Nolakoa da? ");
            String edukia = scanner.next();

            // Fitxategiaren path-a sortu
            File fitxategia = new File(karpeta, izena);

            // Fitxategia sortu
            try (FileWriter fileWriter = new FileWriter(fitxategia)) {
                // Deskribapena fitxategian idatzi
                fileWriter.write(edukia);
                System.out.println(izena + " fitxategia ongi sortu da.");
            } catch (IOException e) {
                System.out.println("Errorea gertatu da fitxategia sortzerakoan: " + e.getMessage());
            }
        } finally {
            // Scanner objektua itxi
            scanner.close();
        }
    }

}

