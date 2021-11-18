/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *MALKI
 * THIBAULT 
 * @author saidm
 */
import java.util.Random ;
public class Partie {
    Joueur [] ListeJoueurs = new Joueur [2] ;
    Joueur joueurCourant ;
    Grille grilleJeu = null ;
    
    
    Partie(Joueur,Joueur){
        
    }
    
    public void initialiserPartie(){
        
    }
    
    public void debuterPartie(){
        
        
    }
    
   public void attribuerCouleursAuxJoueurs(){
         Random r = new Random()  ;
         boolean couleur ;
         couleur = r.nextBoolean();
            
         if (couleur == true ){
          ListeJoueurs[0].Couleur = "Rouge" ;
          ListeJoueurs[1].Couleur = "Jaune" ;
         }
         else{
          ListeJoueurs[1].Couleur = "Rouge" ;
          ListeJoueurs[0].Couleur = "Jaune" ;  
         }
        
        
        
    }

}
