/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manipnombresint_ringuede_malki;

import java.util.Scanner;

/**
 * fait le 4 octobre 2021
 *
 * @author Delphine Ringuede
 */
public class ManipNombresInt_RINGUEDE_MALKI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // I.Saisie et manipulation de nombres

        Scanner sc = new Scanner(System.in); // fonction qui lit les entres de l'utilisateur 
        // rajout automatique de : import java.util.Scanner;
        System.out.println("Choisissez un entier:");
        int entier1 = sc.nextInt();
        System.out.println("Choisissez un deuxieme entier:");
        int entier2 = sc.nextInt();

        System.out.println("CALCULS DE BASE : \nSomme : " + entier1 + entier2 + "\nDifference : " + (entier1 - entier2)+"\nProduit : "+ entier1*entier2);
        System.out.println("Division euclidienne: \nQuotient entier : "+entier1/entier2+" reste : "+ entier1%entier2);
            
    }

}
