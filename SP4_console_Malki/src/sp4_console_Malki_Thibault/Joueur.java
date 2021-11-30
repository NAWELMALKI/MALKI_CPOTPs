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
        Couleur = couleurjoueur ; // on affecte a la variable Couleur  la couleur que on lui donne   
    } 
 
  public boolean ajouterJeton (Jeton jetonJ){

        int i =0;

        while (ListeJetons[i] != null){ // tant que la liste est pleine
            i = i+1;
            if (i == 21){
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
    // on augmente le nombre de desintegrateur
        
    public  boolean utiliserDesintegrateur(){ 
            if(nombreDesintegrateurs == 0){ // si il n'y a plus de desintegrateur ça renvoie false donc
                return false ;              // on peut plus utiliser de desintegrateur car il n'y en a plus
                
            } 
            else{ 
                nombreDesintegrateurs -- ; 
                return true;
            }  
            // si il reste des desintegrateur,
            // on decremente le nombre de desintegrateur dans la liste.
        
    
        
        
}   

}