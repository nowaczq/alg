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
        CarDistribution cR = new CarDistribution(5,mR.oR.tab);
        System.out.println();
        RoadCalculator rC = new RoadCalculator(len, mR.getConnectionMap(),5,mR.oR.tab);
        int []s = rC.roadCalc(3,mR.getConnectionMap());
        for(int i = 0; i< s.length; i++)
               System.out.println(s[i]);
        String [][] rd = rC.getCarRoadRecorder();
        for(int i = 0; i < 15;i++)
        {
            String []tmp;
            tmp = rd[i][1].split("");
           // System.out.println(rd[i][1]);
            //for(int e = 0; e< tmp.length;e++)
            //    System.out.println(tmp[e]);
            //System.out.println();
        }
        Window w = new Window(rd);
    }
    
    
}
