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
    //création des attributs:
    Joueur ListeJoueurs[] = new Joueur[2];
    Joueur joueurCourant;
    Grille grilleJeu = null;
 
   //création des methodes:
     public Partie(Joueur j1, Joueur j2) {
           ListeJoueurs[0] = j1;  //on place joueur 1 dans la ListeJoueurs
           ListeJoueurs[1] = j2;  // idem pour joueur 2
    }
     
     
     public void initialiserPartie(){
        //on donne un nom a chacun des joueurs
        ListeJoueurs[0] = new Joueur("Joueur 1");
        ListeJoueurs[1] = new Joueur("Joueur 2");
        
        attribuerCouleursAuxJoueurs(); 
       
        while (grilleJeu != null) {   // On vide la grille si elle existait déjà
            grilleJeu.viderGrille();
        }
       
        grilleJeu = new Grille(); //on crée la grille, 

        //on attribut 21 jetons d'une couleur à chaque joueur:
        for (int i = 0; i < 21; i++) {
            ListeJoueurs[0].ajouterJeton(new Jeton(ListeJoueurs[0].Couleur));
            ListeJoueurs[1].ajouterJeton(new Jeton(ListeJoueurs[1].Couleur));
        }
        ListeJoueurs[0].nombreJetonsRestants = 21;
        ListeJoueurs[1].nombreJetonsRestants = 21;
        //System.out.println(joueurCourant.nombreJetonsRestants);

        //PLACEMENT àléatoire des trous noirs et désintégrateurs, avant que les joueurs ne commencent à jouer:  
        Random rand = new Random();
        for (int p=0; p<3 ; p++){    
            int i = rand.nextInt(6) ;
            int j = rand.nextInt(7) ;
            grilleJeu.placerTrouNoir(i, j);   
        }

        for (int p=0; p<3 ; p++){    
            int i = rand.nextInt(6) ;
            int j = rand.nextInt(7) ;
           
            while (grilleJeu.CellulesJeu[i][j].presenceTrouNoir()==true){
                i = rand.nextInt(6) ;
                j = rand.nextInt(7) ;    
            }
            while (grilleJeu.CellulesJeu[i][j].presenceDesintegrateur()==true){
                i = rand.nextInt(6) ;
                j = rand.nextInt(7) ;    
            }
            grilleJeu.placerDesintegrateur(i, j);
        }

        System.out.println("\n\nGrille : ");
        for (int p=0; p<2 ; p++){  
            int i = rand.nextInt(6) ;
            int j = rand.nextInt(7) ;
           
            while (grilleJeu.CellulesJeu[i][j].presenceTrouNoir()==true){
                i = rand.nextInt(6) ;
                j = rand.nextInt(7) ;
            }

            grilleJeu.placerTrouNoir(i, j);
            grilleJeu.placerDesintegrateur(i, j);
        }
       
    }
 
    //la méthode debuterPartie permet de lancer la partie
    public void debuterPartie() {
        Scanner sc = new Scanner(System.in);
        joueurCourant = ListeJoueurs[0];
        int i=1;
       
        while ((grilleJeu.etreRemplie() == false) && (grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])!= true) && grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])!= true) {
        //Vérification que la grille est n'est pas pleine et que aucun des joueurs n'a gagné.
            System.out.println(joueurCourant + " est entrain de jouer."); 
            grilleJeu.afficherGrilleSurConsole();
            boolean CoupValide = false;
            int coup=-1;
            int x = -1;
            int y = -1;
            int colonne = -1;
            // j'initialise toutes les variables dont je vais me servir au debut, pour pouvoir m'en reservir après.
            Jeton j = joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants -1];
           
           
    // VÉRIFICATION QUE LE COUP JOUÉ EST JUSTE :
            while (CoupValide == false){
                System.out.println("\nQue voulez vous jouer ? (1)Ajouter Jeton Colonne ; (2)Recuperer Jeton ; (3)Désintégrateur");
                 coup = sc.nextInt();
               
                if (coup > 3 || coup < 1){ // le coup doit correspondre à 1, 2 ou 3.
                    System.out.println("ERREUR : Veuillez saisir un nombre entre 1 et 3.");
                }
               
         //placer DÉSINTÉGRATEUR
                if (coup == 3){
                    if (joueurCourant.nombreDesintegrateurs == 0){
                        System.out.println("ERREUR. Vous n'avez pas de désintegrateur. Veuillez jouer autre chose :");  
                    }
                   
                    //on demande au joueur de choisir les coordonnées de la cellule dans laquelle il veut placer son désintégrateur.
                    else if (joueurCourant.nombreDesintegrateurs > 0) {
                        System.out.println("Dans quelle case voulez vous placer le désintégrateur ?");
                        System.out.println("ligne :");
                        x = sc.nextInt();                        
                        System.out.println("colonne :");
                        y = sc.nextInt();
                        if ((x > 1|| x < 8) && (y > 1|| y < 7)) {
                            System.out.println("ERREUR. Case hors du tableau.");  
                        }  
                    }
                   
                    else {
                            CoupValide = true;
                                }
                }
               
         // RÉCUPÉRER JETON :
                if (coup ==2 ){
                    if (grilleJeu.etreVide() == true){
                        System.out.println("ERREUR. Vous n'avez pas encore placé de jeton."); 
                    }

                    if (grilleJeu.etreVide() != true){
                        System.out.println("Dans quelle case voulez vous recuperer le jeton ?");
                        System.out.println("colonne :");
                        y = sc.nextInt()-1;
                        System.out.println("ligne :");
                        x = sc.nextInt()-1;
                        System.out.println("grilleJeu.lireCouleurDuJeton(x, y) : " + grilleJeu.lireCouleurDuJeton(x, y));
                        if (grilleJeu.lireCouleurDuJeton(x, y) != joueurCourant.Couleur){
                            System.out.println("ERREUR. Le jeton récupéré n'est pas le votre ou case vide.");
                            CoupValide = false;
                        }
                       
                        else {
                            CoupValide = true; // le joueur a pu recuperer son jeton.
                        }
                           
                        }
                    }
               
               
         // PLACER COLONNE :
                if (coup == 1){
                System.out.println("Dans quelle colonne voulez-vous placer votre jeton ?");
                colonne = sc.nextInt() -1;

                // tant que l'utilisateur ne rentre pas une bonne colonne
                if (colonne>6){
                    System.out.println("ERREUR. Chiffre incorrect. Veuillez saisir un nombre entre 0 et 6. \nDans quelle colonne voulez-vous placer votre jeton ?");  
                }

                // tant que l'utilisateur choisis une colonne remplie on lui affcihe un message d'erreur.
                if (grilleJeu.colonneRemplie(colonne) == false){
                    System.out.println("ERREUR. Colonne remplie.");
                   
                }
               
                else {
                    CoupValide = true; //grillejeu si les jeotns sont au bon endroit
                }  
              }
            }
           
    // COUP VALIDE      
       // PLACER DESINTEGRATEUR :
       
            if (coup ==3 ){
                grilleJeu.CellulesJeu[x][y].recupererJeton();
                System.out.println("Vous avez désintégré le jeton de votre adversaire. Il a explosé en particules subatomiques et est définitivement perdu. MOAHHH");
                grilleJeu.tasserGrille(y);
                }
           
       // Ajouter Jeton Colonne:
            if (coup == 1){
                joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1]=null;
                joueurCourant.nombreJetonsRestants--;  
               
             
                // le jeton a pu etre ajouter dans la colonne
                i=0;
                while (grilleJeu.CellulesJeu[i][colonne].recupererJeton() != null){
                i +=1;
                }
                // i = indice de la premiere case dans laquelle on a mis le jeton.
                grilleJeu.ajouterJetonDansColonne(j, colonne);
             
            // CAS 1 : Le joueur place son jeton sur un désintégrateur ;
                if (grilleJeu.CellulesJeu[i][colonne].presenceDesintegrateur()){
                    joueurCourant.nombreDesintegrateurs =+1 ;
                    System.out.println("VOUS AVEZ RÉCUPÉRÉ UN DÉSINTÉGRATEUR ! \nVous avez actuellement " + joueurCourant.nombreDesintegrateurs + " désintégrateur(s).");
                }

            // CAS 2 : Le joueur place son jeton sur un trou noir;
                if (grilleJeu.CellulesJeu[i][colonne].presenceTrouNoir()){
                    grilleJeu.CellulesJeu[i][colonne].activerTrouNoir();
                    System.out.println("Votre jeton a été absorbé par un trou noir... ");
                }
            }
           

       // RÉCUPÉRER JETON :
            if (coup ==2 ){
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
            System.out.println( joueurCourant + " À GAGNÉ !");  
        }
       
        else if ((grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])== true) && (grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])!= true)) {
            System.out.println(ListeJoueurs[0] + " À GAGNÉ !");
        }
       
        else if ((grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])== true) && (grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])!= true)) {
            System.out.println(ListeJoueurs[1] + " À GAGNÉ !");              
        }
       
        else if (grilleJeu.etreRemplie() == true) {
            System.out.println(ListeJoueurs[0] + " À GAGNÉ !");    
        }    
    }

       
       
 public void attribuerCouleursAuxJoueurs(){ //permet d'attribuer des couleurs aléatoirement aux joueurs
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