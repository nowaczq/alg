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
        int [][]map= new int[5][5];
        int len = mR.getSizeOfMap();
        int inf = 1000000;
        for(int i = 0;i<5;i++)
            for(int j=0;j<5;j++)
                map[i][j] = inf;
        map[0][1] = 1;
        map[0][4] = 6;
        map[1][0] = 4;
        map[1][2] = 1;
        map[1][4] = 8;
        map[2][3] = 2;
        map[3][4] = 1;
        map[4][1] = 5;
        PathfinderDijkstra pD = new PathfinderDijkstra(5,map);
        mR.drawMap();
        System.out.println();
        
        //poprawić numerację w grafie i będzie Dijkstra działała
        //PathfinderDijkstra pD = new PathfinderDijkstra(len,map);
        int []path=pD.getPath(4,0);
        for(int i=0;i<path.length;i++)
            System.out.print(path[i]);
        System.out.println();
    }
    
}
