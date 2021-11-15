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
        
        
        if (jetonCourant== null){
            return false ;
        }
        
        if(jetonCourant!= null){
            jetonCourant= null;
            return false ;
        }
    }   
    
        boolean  presenceTrouNoir(){
        if(trouNoir== true){
            return true ;
        }
        else{
            return false ;
        }
    }
   
     boolean presenceDesintegrateur(){
        if(desintegrateur==true){
            return true ;
        }
        else{
            return false ;
        }
     }   
     
     boolean  placerDesintegrateur(){
              
         if (desintegrateur== true){
             return false ;
         }
         
         if(desintegrateur== false){
             desintegrateur=true ;
             return true ;
         }
             
     }
    
     boolean placerTrouNoir(){
         
         if (trouNoir== true){
             return false ;
         }
         
         if(trouNoir== false){
             trouNoir=true ;
             return true ;
         }
        
         
         
     }
     
     boolean recupererDesintegrateur(){
         
         if(desintegrateur == true ){
             desintegrateur=false ;
             return true ;
         }
         else{
             return false ;
         }
     }
     boolean activerTrouNoir(){
         if(trouNoir==true){
            jetonCourant= null;
            return true ;
            
         }
         else{
             return false;
         }
     }
     
}
