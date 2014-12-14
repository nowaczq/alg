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
    public OrderHeap oH;
    private int []carCapacity;
    private int []road;
    
    public CarDistribution(int n, OrderStock t[])
    {
        oH = new OrderHeap();
        this.numberOfCars = n;
        oH.tab = t;
        this.carCapacity = new int[numberOfCars];
    }
    
    public void insertCapacity(int cap, int car)
    {
        this.carCapacity[car] = cap;
    }
    public int []getCarCapacity()
    {
        return this.carCapacity;
    }
    public int getCarCapacityByNumber(int numb)
    {
        return this.carCapacity[numb];
    }
    public int []packageControlSystem(int car)
    {
        int capacity = this.carCapacity[car];
        this.road = new int[capacity];
        for(int i = 0;i<capacity;i++)
        {
            road[i] = oH.pop().getDestination();
        }
        return this.road;
    
    }
}
