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
      return CellulesJeu[]
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
       
        return CellulesJeu[x][y].lireCouleurduJeton();
            
        
}

boolean colonneRemplie(int y){
   for ( y=0 ; y<CellulesJeu.length -1 ; y++) {
       if (CellulesJeu[y]!= null){
           return true ;
       }
   }
}

boolean supprimerJeton(int x,int y){
            
                if (CellulesJeu[x][y]== null){
                    return false ;    
                }    
                if (CellulesJeu[x][y]!= null){
                    CellulesJeu[x][y]= null ;
                
                    return true ; 
                }    
        
               
        }        
    

boolean recupererJeton(int x,int y){

    CellulesJeu[x][y]
}

boolean placerTrouNoir(int x, int y){
    
    if(CellulesJeu[x][y].placerTrouNoir()== true ){
        return true ;
    }
    else{
        return false ;
    }
}

boolean placerDesintegrateur(int x , int y ){
    
    if(CellulesJeu[x][y].placerDesintegrateur()== true ){
        return true ;
    }
    else{
        return false ;
    }
    
    
}