/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind_thibault_malki;

/**
 *
 * @author saidm
 */
public class Mastermind_Thibault_Malki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Joueur j1 = new Joueur ("Joueur 1") ;
    
       plateau G = new plateau();
       G.AfficherGrillesurConsole();
       
       Partie partie  = new Partie();
       partie.InitialiserPartie();
       partie.DebuterPartie();
    }
    
}
