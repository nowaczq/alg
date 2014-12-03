/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverysystem;

/**
 *
 * @author Mateusz
 */
public class DeliverySystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String iF = "mapa.txt";
        String mF = "polaczenia.txt";
        String oF = "paczki.txt";
        MapReader mR;
        mR = new MapReader(iF,mF,oF);
        int [][]map = mR.getConnectionMap();
        int len = mR.getSizeOfMap();
        PathfinderDijkstra pD = new PathfinderDijkstra(len,map);
        mR.drawMap();
        System.out.println();
        
        //poprawić numerację w grafie i będzie Dijkstra działała
        int []path=pD.getPath(6, 6);
        for(int i=0;i<path.length;i++)
            System.out.print(path[i]);
        System.out.println();
    }
    
}
