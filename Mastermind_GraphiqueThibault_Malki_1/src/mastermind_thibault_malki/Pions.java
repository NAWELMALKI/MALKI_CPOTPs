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
public class Pions {
    String Couleur ;
    
    public Pions (String a ){
        Couleur = a ; // on  attribue une couleur au pions 
    }
    
    public String LireCouleur (){
        return Couleur ;  // renvoie la couleur du pions
    }
}
