/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind_thibault_malki;
import java.util.Random ;
/**
 *
 * @author saidm
 */
public class Partie {
    Pions [] CombiSecret = new Pions [4];
    plateau PlateauJeu ;
    //Pions piontJoueur = new Pions();
    String couleurPion ;

    public Partie (Joueur j1){
        
    }
   
    
    public void InitialiserPartie(){
        Random rand = new Random();
        for (int p=0; p<5 ; p++){    
            int i = rand.nextInt(4) ;

            if (i==0){
                couleurPion = "Rouge" ;
            }
                 
            if (i==1){
                couleurPion = "Violet" ;
            }
            
            if (i==2){
                couleurPion = "Bleu" ;
            }
            
            if (i==3){
                
                couleurPion = "Vert" ;
            }
            
            if (i==4){
                 couleurPion = "Jaune" ;
            }
            
            CombiSecret[p].Couleur = couleurPion;
        }    
    }
    
    public void DebuterPartie (){
        
    }
    
    public boolean EtreGagnant(int ligne){
        //si la 4 case sont identiques à celle de la combinaison mistyère alors c'est gagné !
        int j = 0;
        while (PlateauJeu.PionPlateau[ligne][j].Couleur == CombiSecret[j].Couleur){
            j +=1;
            if (j==4){
                return true;
            }    
        }
        return false;
    }
}
