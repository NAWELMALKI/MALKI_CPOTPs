package sp4_console_Malki_Thibault;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *MALKI
 *THIBAULT 
 * @author saidm
 */
import java.util.Random ;
import java.util.Scanner;

public class Partie {
    Joueur ListeJoueurs[] = new Joueur[2];
    Joueur joueurCourant;
    Grille grilleJeu = null;
 
    
     public Partie(Joueur j1, Joueur j2) {
           ListeJoueurs[0] = j1;  //on place joueur 1 dans la ListeJoueurs
           ListeJoueurs[1] = j2;  // idem pour joueur 2 
    }
    
     public void initialiserPartie(){   
        while (grilleJeu != null) {
            grilleJeu.viderGrille();
        }

        grilleJeu = new Grille();
 

        //on attribut 21 jetons d'une couleur à chaque joueur:
        for (int i = 0; i < 21; i++) {
            ListeJoueurs[0].ajouterJeton(new Jeton(ListeJoueurs[0].Couleur));
            ListeJoueurs[1].ajouterJeton(new Jeton(ListeJoueurs[1].Couleur));
        } 

        //PLACEMENT des trous noirs et désintégrateurs, avant que les joueurs ne commencent à jouer:  
        Random rand = new Random();
        for (int p=0; p<4 ; p++){    
            int i = rand.nextInt(6) ;
            int j = rand.nextInt(7) ;
            grilleJeu.placerTrouNoir(i, j);  
        }

        for (int p=0; p<4 ; p++){    
            int i = rand.nextInt(6) ;
            int j = rand.nextInt(7) ;
            grilleJeu.placerDesintegrateur(i, j);  
        }

        for (int p=0; p<3 ; p++){   
            int i = rand.nextInt(6) ;
            int j = rand.nextInt(7) ;
            grilleJeu.placerTrouNoir(i, j);
            grilleJeu.placerDesintegrateur(i, j);
        }
        
    }
  
  
    public void debuterPartie() {
        Scanner sc = new Scanner(System.in);
        joueurCourant = ListeJoueurs[0];
        int i=1;

        while ((grilleJeu.etreRemplie() == false) && (grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])!= true) && grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])!= true) {

            grilleJeu.afficherGrilleSurConsole();
            System.out.println("Que voulez vous jouer ? (1)Ajouter Jeton Colonne ; (2)Recuperer Jeton ; (3)Désintégrateur");
            int coup = sc.nextInt();
            
            // PLACER DESINTEGRATEUR :
            if (coup ==3 ){
                System.out.println("Dans quelle case voulez vous placer le désintégrateur ?");
                int x = sc.nextInt();
                int y = sc.nextInt();
                
                if (joueurCourant.nombreDesintegrateurs == 0){
                    System.out.println("ERREUR. Vous n'avez pas de désintegrateur... Veuillez jouer autre chose :");
                    System.out.println("Que voulez vous jouer ? (1)Ajouter Jeton Colonne ; (2)Recuperer Jeton");
                    coup = sc.nextInt();               
                }

                else {
                    while (grilleJeu.lireCouleurDuJeton(x, y) == joueurCourant.Couleur){
                    System.out.println("ERREUR. Vous ne pouvez pas désintegrer votre jeton. \nDans quelle case voulez vous placer le désintégrateur ?");
                    x = sc.nextInt();
                    y = sc.nextInt();
                    }
                }
                
                grilleJeu.CellulesJeu[x][y].recupererJeton();
                grilleJeu.tasserGrille(y);
            }

            
            // Ajouter Jeton Colonne:
            if (coup == 1){
                Jeton j = joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants -1];
                joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1]=null;
                joueurCourant.nombreJetonsRestants--;  
                
                System.out.println("Dans quelle colonne voulez-vous placer votre jeton ?");
                int colonne = sc.nextInt(); 

                // tant que l'utilisateur ne rentre pas une bonne colonne
                while (colonne>6){
                    System.out.println("ERREUR. Chiffre incorrect. Veuillez saisir un nombre entre 0 et 6. \nDans quelle colonne voulez-vous placer votre jeton ?");
                    colonne = sc.nextInt(); 
                }

                // tant que l'utilisateur choisis une colonne remplie on lui affcihe un message d'erreur.
                while (grilleJeu.ajouterJetonDansColonne(j, colonne) == false){
                    System.out.println("ERREUR. Colonne remplie. \nDans quelle colonne voulez-vous placer votre jeton ?");
                    colonne = sc.nextInt(); 
                }
                
                grilleJeu.ajouterJetonDansColonne(j, colonne);
                // le jeton a pu etre ajouter dans la colonne
                
                while (grilleJeu.CellulesJeu[i][colonne] == null){
                i +=1;
                }
                // i = indice de la premiere case dans laquelle on a mis le jeton.
  
            // CAS 1 : Le joueur place son jeton sur un désintégrateur ;
            if (grilleJeu.CellulesJeu[i][colonne].presenceDesintegrateur()){
                joueurCourant.nombreDesintegrateurs =+1 ;
            }
            
            // CAS 2 : Le joueur place son jeton sur un trou noir; 
            if (grilleJeu.CellulesJeu[i][colonne].presenceTrouNoir()){
                grilleJeu.CellulesJeu[i][colonne].activerTrouNoir();
            }
            
            
            // CAS 3 : Le joueur place son jeton sur un désintégrateur et un trou noir; 
            
            }
            

            // RÉCUPÉRER JETON :
            if (coup ==2 ){
                System.out.println("Dans quelle case voulez vous recuperer le jeton ?");
                int x = sc.nextInt();
                int y = sc.nextInt(); 

                while (grilleJeu.lireCouleurDuJeton(x, y) != joueurCourant.Couleur){
                    System.out.println("ERREUR. Le jeton récupéré n'est pas le votre ou case vide. \nDans quelle case voulez vous recuperer le jeton ?");
                    x = sc.nextInt();
                    y = sc.nextInt();
                }
                
                //Rajoute le jeton récupéré dans la listeJeton :
                Jeton jTEMP = grilleJeu.CellulesJeu[x][y].recupererJeton();
                joueurCourant.ajouterJeton(jTEMP);
                
                // on tasse la colonne dans laquelle on a récupéré le jeton
                grilleJeu.tasserGrille(y);
            }           

            
            //CHANGEMENT DE JOUEUR :
            if (joueurCourant == ListeJoueurs[1]){
                joueurCourant = ListeJoueurs[0];
                //i+=1; // si JC = J2 => J1 à déja jouer alors on peut passer au jeton n°2 (dans liste ListeJetons)
            }

            else {
                joueurCourant = ListeJoueurs[1];
            } 
        }
        
        // On est sorti de la boucle == il y a un gagnant !
        // DÉTERMINATION DU GAGNANT :
        if ((grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])== true) && (grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])== true)){
            System.out.println( joueurCourant + "à gagné !");  
        }
        
        else if ((grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])== true) && (grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])!= true)) {
            System.out.println(ListeJoueurs[0] + "à gagné !"); 
        }
        
        else if ((grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])== true) && (grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])!= true)) {
            System.out.println(ListeJoueurs[1] + "à gagné !");              
        }
        
        else if (grilleJeu.etreRemplie() == true) {
            System.out.println(ListeJoueurs[0] + "à gagné !");    
        }    
    } 
    
    


        
        
 public void attribuerCouleursAuxJoueurs(){
         Random r = new Random()  ;
         boolean couleur ;
         couleur = r.nextBoolean();
            
         if (couleur == true ){
          ListeJoueurs[0].Couleur = "Rouge" ;
          ListeJoueurs[1].Couleur = "Jaune" ;
         }
         else{
          ListeJoueurs[1].Couleur = "Rouge" ;
          ListeJoueurs[0].Couleur = "Jaune" ;  
         } 
    }

}
