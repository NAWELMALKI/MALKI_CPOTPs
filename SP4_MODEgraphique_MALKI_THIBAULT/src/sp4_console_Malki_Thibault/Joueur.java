package sp4_console_Malki_Thibault;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *MALKI
 * THIBAULT 
 * PUISSANCE 4
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
  
  public void affecterCouleur(String couleurjoueur){
        Couleur = couleurjoueur ;
        
    } 
 
  public boolean ajouterJeton (Jeton jetonJ){

        int i =0;

        while (ListeJetons[i] != null){

            i = i+1;

            if (i == 20){

                return false;

            }

        }

        ListeJetons[i] = jetonJ ;

        nombreJetonsRestants =+ 1 ;

        return true;

    }

    
    
    public void obtenirDesintegrateur(){
            nombreDesintegrateurs ++ ;
    }
        
    public  boolean utiliserDesintegrateur(){ 
            if(nombreDesintegrateurs == 0){
                return false ;
            }
            
            else{ 
                nombreDesintegrateurs -- ; 
                return true;
            }
        
    
        
        
}   

}