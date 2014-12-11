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
public class CarDistribution 
{ 
    private int numberOfCars;
    private OrderStock []tab;
    private int []carCapacity;
    private int []road;
    
    public CarDistribution(int n, OrderStock t[])
    {
        this.numberOfCars = n;
        this.tab = t;
        this.carCapacity = new int[numberOfCars];
    }
    
    public void insertCapacity(int cap, int car)
    {
        this.carCapacity[car] = cap;
    }
    
    public int []packageControlSystem(int car)
    {
        int capacity = this.carCapacity[car];
        this.road = new int[capacity];
        if(premierCondition(capacity) == 0)
        {
            //rozdzielenie paczek z kolejki za pomocą pop
        }
        else
        {
            //wyjęcie paczek z jednego miasta
        }
        return this.road;
    
    }
    
    private int premierCondition(int cap)
    {
        // dla cap jest tyle samo paczek do 1 miasta
        
        return 0;
    }
}
