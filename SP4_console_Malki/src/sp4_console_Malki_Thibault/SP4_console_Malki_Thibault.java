/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp4_console_Malki_Thibault;

/**
 *Malki
 *Thibault
 * TP2 Puissance 4
 */


public class SP4_console_Malki_Thibault {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Jeton j = new Jeton("Rouge") ;
       System.out.print(j.lireCouleur());
       
       Cellule c =new Cellule();
       System.out.print(c.lireCouleurDuJeton());  // affiche du vide
       c.affecterJeton(j);
       System.out.print(c.lireCouleurDuJeton());  // affiche rouge 
       Grille G = new Grille();
       G.afficherGrilleSurConsole();  // affiche grille vierge 
       G.ajouterJetonDansColonne(j,5);
       G.afficherGrilleSurConsole();  // affiche grille avec jeton
        
       
       
        
    }
    
}
