package dambi;

import java.util.Scanner;

public class KontsultatuPelikula {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the title of the movie: ");
        String title = in.next();

        String result = QuickStart.kontsultatuPelikula(title);

        if(!result.equals("")){
            System.out.println("Your movie (" + result + ") exists in the database.");
        } else {
            System.out.println("Your movie (" + result + ") doesn't exist in the database.");
        }
    }
}
