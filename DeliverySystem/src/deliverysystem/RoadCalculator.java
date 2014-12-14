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
public class RoadCalculator 
{
    PathfinderDijkstra pF;
    CarDistribution cR;
    
    public RoadCalculator(int size, int [][]tab, int n, OrderStock []t)
    {
        this.pF = new PathfinderDijkstra(size,tab);
        this.cR = new CarDistribution(n,t);
        for(int i=0;i<5;i++)
        {
            cR.insertCapacity(3, i);
        }
    }
    public int []roadCalc(int startPoint, int [][]map)
    {
        
        int []sum = new int[cR.getCarCapacity().length];
        
        for (int i=0; i < sum.length;i++)
        {
            int counter = 0;
            System.out.println();
            sum[i] = 0;
            int []cap = cR.packageControlSystem(i);
            int []tmp;
            tmp = pF.getPath(startPoint, cap[0]);
            tmp[tmp.length -1] = cap[0];
            
            System.out.println("trasa: ");
            for(int o = 0; o <tmp.length; o++)
                System.out.print(tmp[o]);
            System.out.println();
            if(tmp.length == 2)
            {
                sum[i] += map[tmp[0]][tmp[1]];
            }
            else
            {
               for(int u= 1; u < tmp.length;u++)
                {
                    sum[i] += map[tmp[u-1]][tmp[u]];
                }
            }
            System.out.println("Start: " +startPoint + " koniec: " + cap[0] + " suma: " + sum[i]);
             
            for (int j = 1; j < cap.length; j++)
            {
                
                tmp = pF.getPath(cap[j-1], cap[j]); 
                tmp[tmp.length -1] = cap[j];
                System.out.println("trasa: ");
                for(int o = 0; o <tmp.length; o++)
                    System.out.print(tmp[o]);
                System.out.println();
                if(tmp.length == 2)
                {
                    sum[i] += map[tmp[0]][tmp[1]];
                }
                else
                {
                    for(int u= 1; u < tmp.length;u++)
                    {
                        sum[i] += map[tmp[u-1]][tmp[u]];
                    }
                }
                System.out.println("Start: " + cap[j-1] + " koniec: " + cap[j] + " suma: " + sum[i]);

            }
            System.out.println("Zmiana auta");
            
        }
            
        return sum;
    }
    
}
