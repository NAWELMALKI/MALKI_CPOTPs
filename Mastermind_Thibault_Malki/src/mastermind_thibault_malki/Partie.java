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
    Pions [] CombiSecret = new Pions [4] ;
    Grille PlateauJeu ;

    public Partie (){
        
    }
    public int[][] AnlyseCombi(colonnes,CombiSecret[] ){
        
    }
    
    public void InitialiserPartie(){
        Random rand = new Random();
        for (int p=0; p<5 ; p++){    
            int i = rand.nextInt(5) ;

            if (i==0){
                String couleur = "Rouge"
            }
                 
            if (i==1){
                String couleur = "Violet"
            }
    }
    
    public void DebuterPartie (){
        
    }
}
