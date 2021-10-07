/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stats_ringuede_malki;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author delph
 */
public class Stats_RINGUEDE_MALKI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random generateurAleat = new Random(); // ajout auto de java.util.Random 
        int[] tab = new int[6];
        Scanner sc = new Scanner(System.in);
        // rajout automatique de : import java.util.Scanner;
        System.out.println("Choisissez un entier :");
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int n;
            n = generateurAleat.nextInt(6);
            tab[n]++;
        }
        System.out.print(Arrays.toString(tab));
    }

}
