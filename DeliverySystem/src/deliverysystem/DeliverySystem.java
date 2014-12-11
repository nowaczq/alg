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
        int len = mR.getSizeOfMap();
//        mR.drawMap();
        System.out.println();
        PathfinderDijkstra pD = new PathfinderDijkstra(len,mR.getConnectionMap());
        int []path=pD.getPath(3,2);
        for(int i=0;i<path.length;i++)
            System.out.print(path[i]);
        System.out.println();
    }
    
}
