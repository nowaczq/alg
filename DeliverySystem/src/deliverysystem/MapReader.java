/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverysystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Mateusz
 */
public class MapReader {
    private BufferedReader br;
    private String line;
    private String inFile;
    private String mapFile;
    private String orderFile;
    public int amountOfOrders;
    private String []map;
    private int [][]connectionMap;
    private int sizeOfMap;

    public MapReader(String fileMap,String fileCon,String oF)
    {
        this.inFile =fileMap;
        this.mapFile =fileCon;
        this.orderFile = oF;
        ioMapRead();
        connectionMapRead();
    }
    
    private void ioMapRead() 
    {
        try
        {
          br = new BufferedReader(new FileReader(this.inFile));
          sizeOfMap = Integer.parseInt(br.readLine())+1;
          map = new String[sizeOfMap];
          int i=0;
          map[i]= "#";
          while ((line=br.readLine()) != null)
          {
              String [] p = line.split("\\s+");
              String miasto = p[1];
              map[Integer.parseInt(p[0])+1] = miasto;
          }
          br.close();
        }
        catch(IOException r)
        {
        }
    }
    
    private void connectionMapRead()
    {
        connectionMap = new int[sizeOfMap+1][sizeOfMap+1];
        connectionMap[0][0] = 0;
        for(int i=1;i<sizeOfMap;i++)
            connectionMap[0][i] = i-1;
        for(int i=1;i<sizeOfMap;i++)
            connectionMap[i][0] = i-1;
        try
        {
          br = new BufferedReader(new FileReader(this.mapFile));
          br.readLine();
          while((line = br.readLine()) != null)
          {
              String [] p = line.split("\\s+");
              connectionMap[Integer.parseInt(p[0])+1][Integer.parseInt(p[1])+1] = Integer.parseInt(p[2]);
              connectionMap[Integer.parseInt(p[1])+1][Integer.parseInt(p[0])+1] = Integer.parseInt(p[2]);
          }
          br.close();
        }
        catch(IOException r)
        {
            
        }
    }
    private void orderReader()
    {
        try
        {
          br = new BufferedReader(new FileReader(this.orderFile));
          amountOfOrders = Integer.parseInt(br.readLine());
          OrderHeap oR = new OrderHeap(amountOfOrders);
          while((line = br.readLine()) != null)
          {
              String [] p = line.split("\\s+");
              OrderStock oB = new OrderStock (Integer.parseInt(p[0]),Integer.parseInt(p[1]), Integer.parseInt(p[2]), p[3], Integer.parseInt(p[4]));
              oR.insert(oB);
          }
          br.close();
          System.out.println(oR.t[1]);
        }
        catch(IOException r)
        {
            
        }
       
    }
    public void drawMap()
    {
        for(int i=0;i<sizeOfMap;i++)
        {
            System.out.print(map[i]+" ");
        }
        System.out.println();
        for(int i= 0;i<sizeOfMap;i++)
        {
            for(int j=0;j<sizeOfMap;j++)
                System.out.print(connectionMap[i][j]+ " ");
            System.out.println();
        }
    }
    
}
