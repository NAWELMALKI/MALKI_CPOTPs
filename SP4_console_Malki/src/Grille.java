/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saidm
 */
public class Grille {
   Cellule[][] CellulesJeu = new Cellule[6][7] ;
    
    Grille(){
       
   } 
   
  boolean ajouterJetonDansColonne(Jeton, int){
      
  }
  
  boolean etreRemplie(){
      
      if (CellulesJeu != null){
          return true ;
      }
  }
  
  void viderGrille(){
      CellulesJeu = null ;
  }
  boolean celluleOccupee(int x, int y){
    for ( x=0 ; x<CellulesJeu.length ; x++) {
        for ( y=0 ; y<CellulesJeu.length ; y++) {
            if (null !=CellulesJeu[x][y] ){
                return true ;
            }
        }
    }
}
  
String lireCouleurDuJeton(int x, int y){
        for ( x=0 ; x<CellulesJeu.length ; x++) {
           
            for ( y=0 ; y<CellulesJeu.length ; y++) {
               return CellulesJeu[x][y].lireCouleurduJeton();
            }
        }
}

boolean colonneRemplie(int x){
   for ( x=0 ; x<CellulesJeu.length -1 ; x++) {
       if (CellulesJeu[x]!= null){
           return true ;
       }
   }
}

boolean supprimerJeton(int x,int y){
    // for ( x=0 ; x<CellulesJeu.length ; x++) {
           
       // for ( y=0 ; y<CellulesJeu.length ; y++) {
                CellulesJeu[x][y]= null ;
            
                if (CellulesJeu[x][y]== null){
                    return true ;    
            
                if (CellulesJeu[x][y]!= null){
                    return false ; 
                }    
        
            }   
        }        
    

boolean recupererJeton(int x,int y){

}