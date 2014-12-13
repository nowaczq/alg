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

    public static void main(String[] args) 
    {
        String iF = "mapa.txt";
        String mF = "polaczenia.txt";
        String oF = "paczki.txt";
        MapReader mR;
        mR = new MapReader(iF,mF,oF);
        int len = mR.getSizeOfMap();
        mR.drawMap();
//        System.out.println();
//        PathfinderDijkstra pD = new PathfinderDijkstra(len,mR.getConnectionMap());
//        int []path;
//        path = pD.getPath(4,1);
//        for(int i=0;i<path.length;i++)
//            System.out.print(path[i]);
        CarDistribution cR = new CarDistribution(5,mR.oR.tab);
        System.out.println();
//        for(int i=0;i<5;i++)
//        {
//            cR.insertCapacity((i*4)/3+7, i);
//        }

//        System.out.println(cR.getCarCapacityByNumber(0));
//        int []t= cR.packageControlSystem(0);
//        for(int i = 0; i < t.length;i++)
//        {
//            System.out.print(t[i] + " ");
//        }
        RoadCalculator rC = new RoadCalculator(len, mR.getConnectionMap(),5,mR.oR.tab);
        int []s = rC.roadCalc(3,mR.getConnectionMap());
        for(int i = 0; i< s.length; i++)
            System.out.println(s[i]);
//        mR.oR.pop();
//        mR.oR.heapPrinter();
    }
    
}
