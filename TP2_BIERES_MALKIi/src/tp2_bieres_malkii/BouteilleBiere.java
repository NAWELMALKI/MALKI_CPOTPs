/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_bieres_malkii;

/**
 *
 * @author saidm
 */
public class BouteilleBiere {
    String nom ;
    double degreAlcool ;
    String brasserie ;
    boolean ouverte=true ;
    
    public BouteilleBiere(String unNom, double unDegre, String 
    uneBrasserie) {
    nom = unNom;
    degreAlcool = unDegre;
    brasserie = uneBrasserie;
    ouverte = false;
    }
    public void Décapsuler() {
        if (ouverte != false ){
            ouverte= true ;
        }
        else{
            ouverte = true;
            System.out.println(" erreur bouteille deja ouverte ");
            
            
        }    
    }
    
            @Override
        public String toString() {
        String chaine_a_retourner;
        chaine_a_retourner = nom + " (" + degreAlcool + " degrés)Ouverte ? "; 
        if (ouverte == true ) chaine_a_retourner += "oui" ;
        else chaine_a_retourner += "non" ;
        return chaine_a_retourner ;
        }

    
    public void lireEtiquette() {
       System.out.println("Bouteille de " + nom +" (" + degreAlcool +
       " degres) \nBrasserie : " + brasserie ) ;

   }

}
