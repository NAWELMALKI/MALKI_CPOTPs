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

            int i = rand.nextInt(7) ;

            int j = rand.nextInt(6) ;

            grilleJeu.placerTrouNoir(i, j);  

        }

        for (int p=0; p<4 ; p++){    

            int i = rand.nextInt() ;

            int j = rand.nextInt() ;

            grilleJeu.placerDesintegrateur(i, j);  

        }

        for (int p=0; p<3 ; p++){    

            int i = rand.nextInt() ;

            int j = rand.nextInt() ;

            grilleJeu.placerTrouNoir(i, j);

            grilleJeu.placerDesintegrateur(i, j);

        }

    }
    public void debuterPartie() {

        Scanner sc = new Scanner(System.in);

        joueurCourant = ListeJoueurs[0];

        int i=0;

       

        while (grilleJeu.etreRemplie() == false || grilleJeu.etreGagnantePourJoueur(joueurCourant)) {

            grilleJeu.afficherGrilleSurConsole();

            System.out.println("Que voulez vous jouer ? (1)Ajouter Jeton Colonne ; (2) Recuperer Jeton ; (3)Désintégrateur");

            int coup = sc.nextInt();

           

            // Ajouter Jeton Colonne:

            if (coup == 1){

                System.out.println("Dans quelle colonne voulez-vous placer votre jeton ?");

                int colonne = sc.nextInt(); 

                // tant que l'utilisateur choisis une colonne remplie on lui affcihe un message d'erreur.

                while (grilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[i], colonne) == false){

                    System.out.println("ERREUR. Colonne remplie. \nDans quelle colonne voulez-vous placer votre jeton ?");

                    colonne = sc.nextInt(); 

                }

            }

                // le jeton a pu etre ajouter dans la colonne

                

                

            // RÉCUPÉRER JETON :

            if (coup ==2 ){

                System.out.println("Dans quelle case voulez vous recuperer le jeton ?");

                int x = sc.nextInt();

                int y = sc.nextInt(); 

                

                while (grilleJeu.recupererJeton(x, y) != joueurCourant.ListeJetons[0]){

                    System.out.println("ERREUR. Le jeton récupéré n'est pas le votre ou case vide. \nDans quelle case voulez vous recuperer le jeton ?");

                    x = sc.nextInt();

                    y = sc.nextInt();

                    grilleJeu.placerDesintegrateur(x,y);

                }

               

                grilleJeu.tasserGrille(y);

               

                //Rajoute le jeton récupéré dans la listeJeton :

                ???

                Jeton j = joueurCourant.ListeJetons[joueurCourant.ListeJetons -1];

                joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants-1]=null;

                joueurCourant.nombreJetonsRestants--;      

            }

               

            // PLACER DESINTEGRATEUR :

            if (coup ==3 ){

                System.out.println("Dans quelle case voulez vous placer le désintégrateur ?");

                int x = sc.nextInt();

                int y = sc.nextInt();

                grilleJeu.placerDesintegrateur(x,y);

               

                while (grilleJeu.placerDesintegrateur(x,y) == false){

                    System.out.println("ERREUR. Désintégrateur déja présent ou case vide. \nDans quelle case voulez vous placer le désintégrateur ?");

                    x = sc.nextInt();

                    y = sc.nextInt();

                    grilleJeu.placerDesintegrateur(x,y);

                }

            }  

            

            //CHANGEMENT DE JOUEUR :

            if (joueurCourant == ListeJoueurs[1]){

                joueurCourant = ListeJoueurs[0];

                i+=1; // si JC = J2 => J1 à déja jouer alors on peut passer au jeton n°2 (dans liste ListeJetons)

            }

            else {

                joueurCourant = ListeJoueurs[1];

            } 

        }

       

        if (grilleJeu.etreRemplie() == true || grilleJeu.etreGagnantePourJoueur(joueurCourant)) {

            System.out.print("FIN");

        }

   

    } 


        
        
 public   void attribuerCouleursAuxJoueurs(){
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
