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
    //Pions PionsCourant ;
    public plateau() {
        //PionsCourant = null ;
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
        
    }
    
    public boolean AjouterJetonLigne(int ligne, int colonne, Pions PionsCourant){
        if (PionPlateau[ligne][colonne]== null){
               PionPlateau[ligne][colonne]= PionsCourant ;          
                       return true;
            }
        else {
            return false ;
        }
    }
    

}
