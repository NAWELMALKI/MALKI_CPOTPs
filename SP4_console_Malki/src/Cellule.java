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
        if (jetonCourant!= null) {
            return jetonCourant.Couleur;
        }           
    }
    
    public Jeton recupererJeton(){
        
        return jetonCourant ;
        
    }
    
   public boolean  supprimerJeton(){
        
        
        if (jetonCourant== null){
            return false ;
        }
        
        if(jetonCourant!= null){
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
         
         if(desintegrateur== false){
             desintegrateur=true ;
             return true ;
         }
             
     }
    
    public boolean placerTrouNoir(){
         
         if (trouNoir== true){
             return false ;
         }
         
         if(trouNoir== false){
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
            jetonCourant= null;
            return true ;
            
         }
         else{
             return false;
         }
     }
     
}
