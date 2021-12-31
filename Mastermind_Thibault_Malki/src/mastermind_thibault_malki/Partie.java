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
    // Pions [] CombiSecret = new Pions [4];
    String[]CombiSecret = new String[5];
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
            
            CombiSecret[p]= couleurPion;
        }    
    }
    
    public void DebuterPartie (){
        int ligne =0 ;
        
        while ( (EtreGagnant(ligne)==false) ){
        PlateauJeu.AfficherGrillesurConsole();
        
        Scanner sc = new Scanner(System.in);  
        String[]CouleurJoueur = new String[5];

        
        CouleurJoueur[0] = "Violet";
        CouleurJoueur[1] = "Vert";
        CouleurJoueur[2] = "Rouge";
        CouleurJoueur[3] = "Jaune";
        CouleurJoueur[4] = "Bleu";
        
 
        
        System.out.println("\n Que voulez vous jouer ? (0)Un Pion Violet ; (1)Un Pion Vert ; (2) Un Pion Rouge ; (3) Un Pion Jaune ; (4) Un Pion Bleu");
        for (int i = 0; i < 4; i++) {
            int cpt = i + 1;
            System.out.println("Que voulez-vous jouer pour le numero " + cpt + ": ");
            
            
            int couleurchoisi = sc.nextInt();
            PlateauJeu.PionPlateau[ligne][i].Couleur = CouleurJoueur[couleurchoisi];
            AnalyseCombi(ligne);
            
   
        }   
         ligne = ligne +1 ;   

        
    
    }
      // if(PlateauJeu.EtreRemplieTotal(ligne)== true){
      //     System.out.println("Vous avez perdu !!!");
      // }
       if(EtreGagnant(ligne)== true){
           System.out.println("Vous avez pERDUE !!!");
       }
    }
    public boolean EtreGagnant(int ligne){
        //si la 4 case sont identiques à celle de la combinaison mistyère alors c'est gagné !
        int j = 0;
        while (PlateauJeu.PionPlateau[ligne][j].Couleur == CombiSecret[j]){
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
            if (PlateauJeu.PionPlateau[ligne][i].Couleur == CombiSecret[i]){
                if (check[i] ==  false){
                        check[i] = true;
                        BienPlace +=1;
                }
                PlateauJeu.GrilleAide[0] = BienPlace ;
            }
        }
        
        for (int j=0; j<4; j++){
            for(int p = 0; p<4; p++){
                if ((PlateauJeu.PionPlateau[ligne][j].Couleur == CombiSecret[p])&&(PlateauJeu.PionPlateau[ligne][p].Couleur != CombiSecret[p])){
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
