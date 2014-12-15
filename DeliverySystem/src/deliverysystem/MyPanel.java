/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverysystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.swing.JPanel;

/**
 *
 * @author Mateusz
 */
public class MyPanel extends JPanel {
    
        private int [][]pointTable;
        private int amountOfPeaks;
        private String [][]rd;
	public MyPanel(int a, String [][]t)
        {
                this.rd = t;
		setPreferredSize(new Dimension(700, 750));
                this.amountOfPeaks = a;
                pointTable = new int[this.amountOfPeaks][3];
	}

	@Override
        
        //POPRAWIĆ RYSOWANIE W GRAFIE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	protected void paintComponent(Graphics g) 
        {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
                for (int i =0; i<this.amountOfPeaks;i++)
                {
                    
                    double a = 6.283185 * i / (this.amountOfPeaks - 1);
                    pointTable[i][0] = i;
                    pointTable[i][1] =(int) (350 + sin(a)*300 - (20/2));
                    pointTable[i][2] =(int) (350 + cos(a)*300 - (20/2));
                    if(i!= (this.amountOfPeaks -1)) 
                    {
                        g2d.setColor(Color.black);
                        g2d.drawString(String.valueOf(i), pointTable[i][1] - 5 , pointTable[i][2] - 5);
                    }
                    g2d.setColor(Color.orange);
                    g2d.fillOval(pointTable[i][1], pointTable[i][2], 20, 20);

                    
                    
                }
                for(int j = 0; j < 15;j++)
                {
                        String []tmp;
                        tmp = rd[j][1].split("");
                        for(int y= 1 ;y<tmp.length;y++)
                        {
                            int X = Integer.parseInt(tmp[y-1]);
                            int Y = Integer.parseInt(tmp[y]);
                            g2d.drawLine(pointTable[X][1], pointTable[X][2], pointTable[Y][1], pointTable[Y][2]);
                        }
                        
                }
                try
                { Thread.sleep(500); } 
                catch(InterruptedException ex)
                { Thread.currentThread().interrupt(); }
                
	}
}
