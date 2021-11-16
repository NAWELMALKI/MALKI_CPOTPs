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
   
 
public boolean etreRemplie(){
      
      if (CellulesJeu != null){
          return true ;
      }
  }
  
  public void viderGrille(){
      CellulesJeu = null ;
  }
  public boolean celluleOccupee(int ligne, int colonne){

        if (CellulesJeu[ligne][colonne] != null){

            return true;

        }

        else {

            return false;

        }

    }
  
public String lireCouleurDuJeton(int x, int y){
       
        return CellulesJeu[x][y].lireCouleurduJeton();
            
        
}

public boolean colonneRemplie(int y){
   for ( y=0 ; y<CellulesJeu.length -1 ; y++) {
       if (CellulesJeu[y]!= null){
           return true ;
       }
   }
}

public boolean supprimerJeton(int x,int y){
            
                if (CellulesJeu[x][y]== null){
                    return false ;    
                }    
                if (CellulesJeu[x][y]!= null){
                    CellulesJeu[x][y]= null ;
                
                    return true ; 
                }    
        
               
        }        
    

public Jeton recupererJeton(int x,int y){
    Jeton recupjeton ;
    recupjeton =CellulesJeu[x][y].recupererJeton() ;
    CellulesJeu[x][y].supprimerJeton() ;
    return recupjeton ;
}

public boolean placerTrouNoir(int x, int y){
    
    if(CellulesJeu[x][y].placerTrouNoir()== true ){
        return true ;
    }
    else{
        return false ;
    }
}

 public boolean placerDesintegrateur(int x , int y ){
    
    if(CellulesJeu[x][y].placerDesintegrateur()== true ){
        return true ;
    }
    else{
        return false ;
    }
    
}

    public boolean ajouterJetonDansColonne(Jeton jetonJoueur, int colonne){

        int i = 0;

        while (CellulesJeu[i][colonne] == null){

                i +=1;

                if (i > 6) {

                    return false;

                }

            }

        CellulesJeu[i][colonne].affecterJeton(jetonJoueur);

            return true;

    }

}