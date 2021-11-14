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
    Jeton jetonCourant ;
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
    
    Jeton recupererJeton(){
        
        return jetonCourant ;
        
    }
    
    boolean  supprimerJeton(){
        jetonCourant= null;
        
        if (jetonCourant== null){
            return true ;
        }
        
        if(jetonCourant!= null){
            return false ;
        }
    
    }    
        boolean  presenceTrouNoir(){
        if(trouNoir!= null){
            return true ;
        }
    }
   
     boolean presenceDesintegrateur(){
        if(desintegrateur!= null){
            return true ;
        } 
     }   
     
     boolean placerTrouNoir(){
         
     }
    
}
