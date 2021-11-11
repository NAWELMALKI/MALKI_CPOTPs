/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_manip_malki;

/**
 *
 * @author saidm
 */
public class TP2_manip_MALKI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here*
        
        Tartiflette assiette1 = new Tartiflette(500) ;
        Tartiflette assiette2 = new Tartiflette(600) ;
        Tartiflette assiette3 = assiette2 ;         // 2 tartiflettes ont été creer avec des valeurs égales
        int valeur =  assiette1.nbCalories ;
        System.out.println("nb de calories de Assiette 2 : " + 
        assiette2.nbCalories) ;
        System.out.println("nb de calories de Assiette 3 : " + 
        assiette3.nbCalories) ;
        int valeur2 =  assiette2.nbCalories ;
        System.out.println(valeur2);
        // Probleme au niveau du nombre de calorie qui reste à 0
        // Affichage reussi de valeur2 mais qui reste à 0
        
        int echange=assiette1.nbCalories ; 
        // Tartiflette assiette1 = new Tartiflette(600) ; 
        //Tartiflette assiette2 = new Tartiflette(500) ; UNE ERREUR SE CREE , variable ne peut pas etre redefini

        
        //Moussaka assiette666 = assiette1 ; //deux classes ne peuvent pas etre convertie 
        //Moussaka assiette667 = new Tartiflette() ; //  une reference objet qui annoce referencer un type d'objet
        // ne peut referencer un autre type 

        
    }
    
}
