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
       jetonCourant= null; // jeton courant est initialisé null
    }
       
   

    public boolean affecterJeton(Jeton entree) {

        if (jetonCourant == null) {
            jetonCourant = entree; // si jetonCourant est null on lui affecte une valeur 
            return true;    // renvoie vraie
        }
        else {
             return false;  
                    }

    }
    
    public String lireCouleurDuJeton(){
        if (jetonCourant == null){
            return "vide"; // permet de lire la couleur du jeton 
            // si celle ci il n'y a pas de jeton, on renvoie vide
            
        }
        else {
            return jetonCourant.Couleur; // si un jeton est present , on renvoie sa couleur
        }           
        // return null;
    }
    
    public Jeton recupererJeton(){ 
        return jetonCourant ;     
    }
    
   public boolean  supprimerJeton(){
        // la methode permet de supprimer les jeton, elle renvoie 
        // vrai si 
        
        if (jetonCourant== null){
            return false ; // 
        }
        
        else{
            
            return true ;
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
