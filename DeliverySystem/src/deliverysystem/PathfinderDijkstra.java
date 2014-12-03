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
public class PathfinderDijkstra {
    private int inf = 1000000;
    private int [][]tab;
    
    public PathfinderDijkstra(int size, int [][]t)
    {
        this.tab = new int[size][size];
        this.tab = t;
    }
    
    public int []getPath(int source, int destination)
    {
        int graphSize = tab.length;
        int []distance = new int[graphSize];
        int []previous = new int[graphSize];
        int []nodes = new int[graphSize];
        
        for(int i=0; i < distance.length; i++)
        {
            distance[i] = previous[i] = inf;
            nodes[i] = i;
        }
        
        distance[source] = 0;
        
        do
        {
            int smallest = nodes[0];
            int smallestIndex = 0;
            for(int i = 1; i < graphSize; i++)
            {
                if(distance[nodes[i]] < distance[smallest])
                {
                    smallest = nodes[i];
                    smallestIndex = i;
                }
            }
            graphSize--;
            nodes[smallestIndex] = nodes[graphSize];
            
            if(distance[smallest] == inf || smallest == destination)
                break;
            
            for(int i = 0; i < graphSize; i++)
            {
                int v= nodes[i];
                int newDistance = distance[smallest] + tab[smallest][v];
                if(newDistance < distance[v])
                {
                    distance[v] = newDistance;
                    previous[v] = smallest;
                }
                
            }
            
        } while( graphSize > 0);
        return reconstructPath(previous, source, destination);        
    }
    
    public int[]reconstructPath (int []prev, int src, int dest)
    {
        int []ret = new int[prev.length];
        int currentNode = 0;
        ret[currentNode] = dest;
        
        while(ret[currentNode] != inf && ret[currentNode] != src)
        {
            ret[currentNode + 1] = prev[ret[currentNode]];
            currentNode++;
        }
        if(ret[currentNode] != src)
            return null;
        int []reversed = new int[currentNode+1];
        for(int i = currentNode; i >0; i--)
            reversed[currentNode-i]=ret[i];
            
        
        return reversed;
    }
}
