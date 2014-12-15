/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverysystem;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Mateusz
 */
public class Window extends JFrame 
{
	
    public Window(String [][]e) 
    {
        super("Rysowanie");
      
        JPanel panel = new MyPanel(20,e);

        add(panel);

	pack();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
    }
}
    



