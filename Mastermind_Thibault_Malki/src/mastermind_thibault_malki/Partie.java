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
    String[]CombiSecret = new String[5]; // on a creer un tableau CombiSecret qui est compose 
    // de la combinaison secrete de l'ordinateur
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
        for (int p=0; p<5 ; p++){    // cette boucle permet d'inistialise dee facons aléatoire la combi secrete
            int i = rand.nextInt(4) ; // on attribue à i une valeur aléatoire

            if (i==0){
                couleurPion = "Rouge" ; // en fonction de la couleur aléatoire donné a i on lui attribue une couleur
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
            
            CombiSecret[p]= couleurPion; // a chaque cellule du tableau, sont attribuées une couleur
        }    
    }
    
    public void DebuterPartie (){
        int ligne =0 ; // cette fonction est le probleme du programme en effet elle ne fonctionne pas completement 
        // apres de nombreux essaie, principalement lors de l'appel de la methode analyse combi 
        // qui ne renvoie pas ce que l'on cherche
        
        while ( (EtreGagnant(ligne)==false) ){ // l'objectif était de faire tourner le jeu tant que le joueur n'est pas
            // gagnant
            
        PlateauJeu.AfficherGrillesurConsole();

        
        Scanner sc = new Scanner(System.in);  
        String[]CouleurJoueur = new String[5]; // on creer alors un tableau composé des couleurs que le joueur peut choisir

        
        CouleurJoueur[0] = "Violet";
        CouleurJoueur[1] = "Vert";
        CouleurJoueur[2] = "Rouge";
        CouleurJoueur[3] = "Jaune";
        CouleurJoueur[4] = "Bleu";
        
 
        
        System.out.println("\n Que voulez vous jouer ? (0)Un Pion Violet ; (1)Un Pion Vert ; (2) Un Pion Rouge ; (3) Un Pion Jaune ; (4) Un Pion Bleu");
        for (int i = 0; i < 4; i++) { // on lui propose quelle pion souhaite il jouer en fonction de la colonne
            int cpt = i + 1; // pour chaque colonne on lui demande une couleur de pions 
            System.out.println("Que voulez-vous jouer pour le numero " + cpt + ": ");
            
            
            int couleurchoisi = sc.nextInt(); // la valeur  choisi est attribué à la variable 
            PlateauJeu.PionPlateau[ligne][i].Couleur = CouleurJoueur[couleurchoisi]; // on suppose que l'erreur vient de ces ligne 
            // en effet on atribue CouleurJoueur[] à la ligne du tableau correspondant 
             System.out.println(AnalyseCombi(ligne)); // puis on appel la methode analysecombi, l'erreur viendrait de cette ligne de code
          
             // dans cette ligne on appel la methode mais celle ci ne prend pas en compte la ligne 94
        }  
        // int s [] = AnalyseCombi(ligne) ;
        
        
         
         ligne = ligne +1 ;   

        
    
    }
      // if(PlateauJeu.EtreRemplieTotal(ligne)== true){
      //     System.out.println("Vous avez perdu !!!");
      // }
       if(EtreGagnant(ligne)== true){
           System.out.println("Vous avez GAGNE !!!");
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
                if (check[i] ==  false){// si la combisecret est egale à la ligne du joueur 
                        check[i] = true; // check est egale à true 
                        BienPlace +=1;
                }
                PlateauJeu.GrilleAide[0] = BienPlace ; // on place sur le tableau grille aide, une valeur bien place
                System.out.println(PlateauJeu.GrilleAide[0]);
            }
            
        }
        
        for (int j=0; j<4; j++){
            for(int p = 0; p<4; p++){
                if ((PlateauJeu.PionPlateau[ligne][j].Couleur == CombiSecret[p])&&(PlateauJeu.PionPlateau[ligne][p].Couleur != CombiSecret[p])){
                    if (check[p] ==  false){
                        check[p] = true;
                        PasBP +=1;  // si un pions est mal place mais que sa couleur correspond à un pions de la combi secrete
                    }
                    PlateauJeu.GrilleAide[1] = PasBP ;
                   System.out.println(PlateauJeu.GrilleAide[1]); // sur la grille aide , on a pasbp affiche
                }
            }         
        }
        
        return PlateauJeu.GrilleAide;
    }
}
