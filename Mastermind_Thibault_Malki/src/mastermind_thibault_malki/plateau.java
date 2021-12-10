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
    pion[][] PionPlateau = new pion[12][4];
    pion[][] GrilleAide = new pion[12][2];
    
    public plateau() {
        
    }
    
    public void LireCouleurPion(int case){
        return PionPlateau[ligne][colonne].lireCouleur();
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
