/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp4_console_Malki_Thibault;


import java.awt.Graphics;
import javax.swing.ImageIcon;



import javax.swing.JButton;



/**
 *
 * @author saidm
 */
public class CelluleGraphique extends JButton {
    Cellule celluleAssociee ;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/image/JETONROUGE.png"));
    
    public CelluleGraphique (Cellule uneCellule){
        celluleAssociee = uneCellule ;
        
    }
    
    @Override 
    public void paintComponent(Graphics G){
       super.paintComponent(G);
        setIcon(img_vide);
    }
    
}
