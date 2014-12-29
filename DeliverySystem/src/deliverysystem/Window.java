/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverysystem;
import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.visualization.*;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

import java.awt.Dimension;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Mateusz
 */
public class Window 
{
    private String [][]rd;
    OrderStock []tab;
    private int [][]p;
    VisualizationViewer<Integer, String> vv;
    
    public Window (String [][]t, int [][]m, OrderStock []e) throws InterruptedException
    {
        this.rd =t;
        this.p =m;
        this.tab =e;
        getGraph();	
    }
    
    public void getGraph() throws InterruptedException 
    {
        int [][]y = this.p;
        Graph<Integer, String> basis = new SparseMultigraph<>();
        for(int i = 0; i< y.length; i++)
            basis.addVertex(i);
        int cnt = 0;
        
        for(int i = 0; i < y.length; i++)
        {
            for(int j = 0; j < y[i].length; j++)
            {
                if(!(y[i][j] == 1000000))
                {
                    
                    basis.addEdge(String.valueOf(y[i][j]), i, j);
                    y[j][i] = 1000000;
                    cnt++;
                }
                if(y[i][j] == 1000000)
                    System.out.print(0+ " ");
                else 
                    System.out.print(y[i][j]+ " ");
            }  
           
            System.out.println();
        }
        
        
	final Layout<Integer, String> layout = new CircleLayout<>(basis);
	layout.setSize(new Dimension(800, 300));
	vv = new VisualizationViewer<>(layout);
	vv.setPreferredSize(new Dimension(800, 650));

        
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller() {
                @Override
                public String transform(Object o) {
                    
                    return String.valueOf(o);
                }});
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller() {
                @Override
                public String transform(Object i) {

                    return String.valueOf(i);
                }});
            
        
	JFrame frame = new JFrame("Simple Graph View ");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("");
        label1.setBounds(10, 400, 800, 100);
        frame.add(label1);
        frame.getContentPane().add(vv);
	vv.setOpaque(false);
	frame.pack();
	frame.setVisible(true); 
        
        for(int i =0; i<this.rd.length; i++)
        {   
                if (i < 15)  
                {
                    String []tmp;
                    tmp = rd[i][1].split("");
                    for(int j = 0; j <tmp.length;j++)
                        setVertex(Integer.parseInt(tmp[j]));
                    label1.setText("Samochód: " + rd[i][0] + "; początek drogi: " + tmp[0] + "; koniec drogi: " + tmp[tmp.length-1] + "; droga: " + rd[i][1] + "; paczka: " + this.tab[i].getLoad()  );
                    TimeUnit.MILLISECONDS.sleep(5000);
                    for(int j = 0; j <5;j++)
                        vv.getRenderContext().getPickedVertexState().pick((Integer)j, false);
                }
            
        }
	 
        
       
    
  }
   public void setVertex(int vertex)
   {
                    vv.getRenderContext().getPickedVertexState().pick((Integer)vertex, true);
                    vv.repaint(); 
   }
}
    



