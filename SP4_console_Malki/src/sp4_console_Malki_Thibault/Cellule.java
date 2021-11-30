package sp4_console_Malki_Thibault;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Malki
 * Thibault
 * TP2 PUISSANCE 4
 * @author saidm
 */
public class Cellule {
    Jeton jetonCourant ;
    boolean trouNoir ;
    boolean desintegrateur ;

    Cellule(){
       jetonCourant= null; 
    }
       
   

    public boolean affecterJeton(Jeton entree) {

        if (jetonCourant == null) {
            jetonCourant = entree;
            return true;
        }
        else {
             return false;  
                    }

    }
    
    public String lireCouleurDuJeton(){
        if (jetonCourant == null){
            return "vide";
            
        }
        else {
            return jetonCourant.Couleur;
        }           
        // return null;
    }
    
    public Jeton recupererJeton(){ 
        return jetonCourant ;     
    }
    
   public boolean  supprimerJeton(){
        
        
        if (jetonCourant== null){
            return false ;
        }
        
        else{
            jetonCourant= null;
            return false ;
        }
    }   
    
    public    boolean  presenceTrouNoir(){
        if(trouNoir== true){
            return true ;
        }
        else{
            return false ;
        }
    }
   
    public boolean presenceDesintegrateur(){
        if(desintegrateur==true){
            return true ;
        }
        else{
            return false ;
        }
     }   
     
    public boolean  placerDesintegrateur(){
              
         if (desintegrateur== true){
             return false ;
         }
         
         else{
             desintegrateur=true ;
             return true ;
         }
             
     }
    
    public boolean placerTrouNoir(){
         
         if (trouNoir== true){
             return false ;
         }
         
         else{
             trouNoir=true ;
             return true ;
         }
        
    }     
     
     
     
    public boolean recupererDesintegrateur(){
         
         if(desintegrateur == true ){
             desintegrateur=false ;
             return true ;
         }
         else{
             return false ;
         }
     }
    public boolean activerTrouNoir(){
         if(trouNoir==true){
            jetonCourant= null ;
            trouNoir = false ;  
            return true ;
            
         }
         else{
             return false;
         }
     }
     
}
