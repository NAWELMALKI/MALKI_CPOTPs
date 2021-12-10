/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_thibault_malki;

/**
 *
 * @author paola
 */
public class plateau {
    Pions[][] PionPlateau = new Pions[12][4];
    Pions[][] GrilleAide = new Pions[12][2];
    
    public plateau() {
        
    }
    
    public String LireCouleurPion(int ligne, int colonne){
        return PionPlateau[ligne][colonne].LireCouleur() ;
    }
    
    public void ViderGrille(){
        for (int i =0; i < 12; i++){    //ligne 12
           for (int j=0; j<4; j++)    //colonne 4
               PionPlateau[i][j] = null;

       }
    }
    
    //on verifie que les colonnes (i.e. les cases) de la lignes soient remplies 
    public boolean EtreRemplie(int ligne){
            for (int i=0; i<4; i++)    // on a 4 case par ligne
                if (PionPlateau[ligne][i] == null){
                    return false;
                }
        return true;
    }
    
    public void AfficherGrillesurConsole(){
         for( int i=5; i>=0 ; i--){
             System.out.println();
             
             for(int j=0 ; j<4 ; j++ ){
                     if( PionPlateau[i][j].LireCouleur() =="Rouge"){ //[i]=lignes [j]=colonnes
                         System.out.print(" R ");
                     }
                     else if( PionPlateau[i][j].LireCouleur() =="Jaune"){
                         System.out.print(" J ");
                     }
                     else if( PionPlateau[i][j].LireCouleur() =="Violet"){
                         System.out.print(" Vio ");
                     }
                     else if( PionPlateau[i][j].LireCouleur() =="Vert"){
                         System.out.print(" V ");
                     }
                     else if( PionPlateau[i][j].LireCouleur() =="Bleu"){
                         System.out.print(" B ");
                     }
                    else if( PionPlateau[i][j].LireCouleur() == null){
                        System.out.print(" - ");
                     }

                else{
                   
                }
            }
         }
    }
    
    public boolean AjouterJetonLigne(int colonne){
        int i = 0;
        while (PionPlateau[i].EtreRemplie(i) != false){
            
        }
        while (PionPlateau[i][colonne].jetonCourant != null){
                i +=1;
                if (i > 5) {
                    i = 5;
                    break ;
                }
            }
    }
    
    public boolean EtreGagnant(Joueur){
        
    }
}
