/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saidm
 */
public class Joueur {
    String Nom ;
    String Couleur ;
    Jeton [] ListeJetons = new Jeton[21] ;
    int nombreDesintegrateurs ;
    int nombreJetonsRestants ;
    
    Joueur(String nomjoueur){
        Nom = nomjoueur ;
    }
    void affecterCouleur(String couleurjoueur){
        Couleur = couleurjoueur ;
        
    } 
    boolean ajouterJeton(Jeton j ){
        
        for ( int i=0 ; i<ListeJetons.length -1 ; i++){
            if( ListeJetons[i] == null) {
                ListeJetons[i] = j ;
                nombreJetonsRestants = nombreJetonsRestants + 1 ; 
                return true ;
            }  
        }
  
        if(ListeJetons[i]!= null){
                    return false ;
        }
    }
    
        void obtenirDesintegrateur(){
            nombreDesintegrateurs ++ ;
    }
        
        boolean utiliserDesintegrateur(){ 
            if(nombreDesintegrateurs == 0){
                return false ;
            }
             nombreDesintegrateurs -- ; 
             return true;
            }
        
    
        
        
}   
