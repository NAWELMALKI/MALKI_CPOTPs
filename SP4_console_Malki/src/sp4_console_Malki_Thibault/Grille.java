package sp4_console_Malki_Thibault;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Malki
 * Thibault
 * TP2 Puissance 4
 */
public class Grille {
   Cellule[][] CellulesJeu = new Cellule[7][8] ;
   
    Grille(){
       for (int i=0; i<6 ; i++){
           for( int j=0 ; j<7 ; j++){
               CellulesJeu[i][j]= new Cellule();
           }
       }
   }
   
 
 public boolean etreRemplie(){
        for (int i =0; i < 6; i++){    //ligne 6
            for (int j=0; j<7; j++)    //colonne 7
                if (CellulesJeu[i][j].jetonCourant == null){
                    return false;
                }
        }
        return true;
    }
 
 public boolean etreVide( ){
        for (int i =0; i < 6; i++){    //ligne 6
            for (int j=0; j<7; j++)    //colonne 7
                if (CellulesJeu[i][j].jetonCourant != null){ // && (CouleurJeton == jetonCourant.Couleur))
                    return false;
                }  
                }
        return true;
    }
 
 public void viderGrille(){
        for (int i =0; i < 6; i++){    //ligne 6
           for (int j=0; j<7; j++)    //colonne 7
               CellulesJeu[i][j] = null;
 
       }      
    }
     
     
  public boolean celluleOccupee(int ligne, int colonne){
        if (CellulesJeu[ligne][colonne].jetonCourant != null){
            return true ;
        }
        else {
            return false;
        }
    }
 
public String lireCouleurDuJeton(int ligne, int colonne){
        return CellulesJeu[ligne][colonne].lireCouleurDuJeton();
}

public boolean colonneRemplie(int colonne){
   for ( colonne=0 ; colonne<CellulesJeu.length -1 ; colonne++) {
       if (CellulesJeu[colonne]!= null){
           return true ;
       }
   }
   return false;
}

 public boolean etreGagnantePourJoueur(Joueur Jgagnant){

        int compteur = 0;

        String CouleurGagnante = Jgagnant.Couleur;

        //cas 1 : LIGNE jeton dans l'a??ra colonne = [0;3]
        for (int i=0; i<6; i++) { //i = ligne
            for (int j=0; j<4; j++){  //j = colonne
            String CouleurCase = lireCouleurDuJeton(i,j);
                if (CouleurCase == CouleurGagnante){ // case = couleur du joueur
                    int p =j;
                    compteur = 0;
                    while (CellulesJeu[i][p].lireCouleurDuJeton()== CouleurGagnante){
                        compteur += 1;
                        p +=1;
                        if (compteur == 4){

                            return true;

                        }

                       

                    }

                }      

                   

            }  

        }

       

        //cas 2 : COLONNE jeton dans l'a??ra ligne=[0;2]

        for (int i=0; i<3; i++) { //i = ligne

            for (int j=0; j<7; j++){  //j = colonne

            String CouleurCase = lireCouleurDuJeton(i,j);

                if (CouleurCase == CouleurGagnante){ // case = couleur du joueur

                    int p =i;
                    compteur = 0;    
                    while (CellulesJeu[p][j].lireCouleurDuJeton()== CouleurGagnante){

                        compteur += 1;

                        p +=1;

                        if (compteur == 4){

                            return true;

                        }

                       

                    }

                }      

                   

            }  

        }

       

        //cas 3 : DIAG jeton dans l'a??ra ligne=[0;2] & colonne = [0;3]

        for (int i=0; i<3; i++) { //i = ligne (resp. p)

            for (int j=0; j<4; j++){  //j = colonne (resp. n)

            String CouleurCase = lireCouleurDuJeton(i,j);

                if (CouleurCase == CouleurGagnante){ // case = couleur du joueur

                    int p =i;

                    int n = j;
                    compteur=0;
                    while (CellulesJeu[p][n].lireCouleurDuJeton()== CouleurGagnante){
                        compteur += 1;
                        p +=1;
                        n +=1;
                        if (compteur == 4){
                            return true;
                        }

                       

                    }

                }      

                   

            }  

        }

       

        //cas 4 : DIAG jeton dans l'a??ra ligne=[3;5] & colonne = [0;3]

        for (int i=3; i<6; i++) { //i = ligne (resp. p)

            for (int j=0; j<4; j++){  //j = colonne (resp. n)

            String CouleurCase = lireCouleurDuJeton(i,j);

                if (CouleurCase == CouleurGagnante){ // case = couleur du joueur
                    int p =i;
                    int n = j;
                    compteur = 0;
                    while (CellulesJeu[p][n].lireCouleurDuJeton()== CouleurGagnante){
                        compteur += 1;
                        p -=1;
                        n +=1;
                        if (compteur == 4){
                            return true;
                        }

                       

                    }

                }      

                   

            }  

        }

        // si rien ne marche => il n'y a pas 4 jetons de la m??me couleurs align??s.
        return false;

    }

 
     public void tasserGrille(int colonne){

        for (int i = 0; i < 5; i++ ){

            if (CellulesJeu[i][colonne].jetonCourant == null){            
                CellulesJeu[i][colonne].jetonCourant = CellulesJeu[i+1][colonne].jetonCourant ; //on descend la cellule

                if (i+1 == 4){
                    CellulesJeu[i+1][colonne].jetonCourant = null; //on met la cellule ?? vide
                }
            }
        }
     }
     
     
    public boolean supprimerJeton(int ligne,int colonne){

                    if (CellulesJeu[ligne][colonne]== null){
                        return false ;    
                    }    
                    else{
                        CellulesJeu[ligne][colonne]= null ;
                        return true ;
                    }    


    }        
   

public Jeton recupererJeton(int ligne ,int colonne){
    Jeton recupjeton ;
    recupjeton =CellulesJeu[ligne][colonne].recupererJeton() ;
    CellulesJeu[ligne][colonne].supprimerJeton() ;
    return recupjeton ;
}

public boolean placerTrouNoir(int ligne, int colonne){
   
    if(CellulesJeu[ligne][colonne].placerTrouNoir()== true ){
        return true ;
    }
    else{
        return false ;
    }
}

 public boolean placerDesintegrateur(int ligne , int colonne ){
    if(CellulesJeu[ligne][colonne].placerDesintegrateur()== true ){
        return true ;
    }
    else{
        return false ;
    }
   
}

    public boolean ajouterJetonDansColonne(Jeton jetonJoueur, int colonne){
        int i = 0;
        while (CellulesJeu[i][colonne].jetonCourant != null){
                i +=1;
                if (i > 5) {
                    i = 5;
                    break ;
                }
            }
       
        boolean stock = CellulesJeu[i][colonne].affecterJeton(jetonJoueur);
       
            return true;
       
    }

     public void afficherGrilleSurConsole(){
         for( int i=5; i>=0 ; i--){
             System.out.println();
             
             for(int j=0 ; j<7 ; j++ ){
                if( CellulesJeu[i][j].jetonCourant != null){
                     if( CellulesJeu[i][j].lireCouleurDuJeton() =="Rouge"){ //[i]=lignes [j]=colonnes
                         System.out.print("R");
                     }
                     else if( CellulesJeu[i][j].lireCouleurDuJeton() =="Jaune"){
                         System.out.print("J");
                     }
                 }
               
               
                else if ( CellulesJeu[i][j].trouNoir == true){
                         System.out.print("@") ; // @ ressemble plus a un trou noir
                 }
               
                else if ( CellulesJeu[i][j].desintegrateur == true){
                          System.out.print("#") ;
                 }

               
                else if( CellulesJeu[i][j].jetonCourant == null){
                    System.out.print("-");
                 }

                else{
                   
                }
           
                 
                 
                 
                 
         }
                 
     
     }
   
}
}
