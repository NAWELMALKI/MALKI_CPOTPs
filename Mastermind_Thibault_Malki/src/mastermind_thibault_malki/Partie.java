/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind_thibault_malki;
import java.util.Random ;
import java.util.Scanner;
/**
 *
 * @author saidm
 */
public class Partie {
    Pions [] CombiSecret = new Pions [4];
    
    plateau PlateauJeu ;
    //Pions piontJoueur = new Pions();
    String couleurPion ;
    // Joueur j1 ;
    public Partie (){
        
    }
   
    
    public void InitialiserPartie(){
        
        while (PlateauJeu != null) {   // On vide la grille si elle existait déjà
            PlateauJeu.ViderGrille();
        }
       
        PlateauJeu = new plateau();
        
        
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
        
        while ((PlateauJeu.EtreRemplie() == false) && (EtreGagnant()!= true)) {
            Scanner sc = new Scanner(System.in);
            PlateauJeu.AfficherGrillesurConsole();
            int coup= 0;
            System.out.println("\nQue voulez vous jouer ? (1)Un Pion Violet ; (2)Un Pion Vert ; (3) Un Pion Rouge ; (4) Un Pion Jaune ; (5) Un Pion Bleu");
            coup = sc.nextInt();
            
            if (coup > 5 || coup < 1){ // le coup doit correspondre à 1, 2 , 3,4,5.
                    System.out.println("ERREUR : Veuillez saisir un nombre entre 1 et 5.");
                }
            
            if (coup == 1){
                
            }
        }
        
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
    
    public int[] AnalyseCombi(int ligne){
        int BienPlace =0;
        int PasBP =0;
        boolean []check = new boolean[4];
        // check = tableau de false
        for (int i=0; i<4; i++){
            check[i] = false;
        }
        
        for (int i=0; i<4; i++){
            if (PlateauJeu.PionPlateau[ligne][i].Couleur == CombiSecret[i].Couleur){
                if (check[i] ==  false){
                        check[i] = true;
                        BienPlace +=1;
                }
                PlateauJeu.GrilleAide[0] = BienPlace ;
            }
        }
        
        for (int j=0; j<4; j++){
            for(int p = 0; p<4; p++){
                if ((PlateauJeu.PionPlateau[ligne][j].Couleur == CombiSecret[p].Couleur)&&(PlateauJeu.PionPlateau[ligne][p].Couleur != CombiSecret[p].Couleur)){
                    if (check[p] ==  false){
                        check[p] = true;
                        PasBP +=1;
                    }
                    PlateauJeu.GrilleAide[1] = PasBP ;
                }
            }         
        }
        
        return PlateauJeu.GrilleAide;
    }
}
