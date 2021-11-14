/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saidm
 */
public class Cellule {
    Jetons jetonCourant ;
    boolean trouNoir ;
    boolean desintegrateur ;
    
    Cellule(){
       jetonCourant= null; 
    }
    
    boolean affecterJeton(Jeton){
       
    }
    
    String lireCouleurduJeton(){
        if (jetonCourant == null){
            return "vide";
            
        }
        if (jetonCourant!= null) {
            return jetonCourant.Couleur;
        }       
    

        
    }
        
}
