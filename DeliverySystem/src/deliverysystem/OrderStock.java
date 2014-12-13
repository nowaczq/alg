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
public class OrderStock
{
    private int listNumber;
    private int base;
    private int destination;
    private String load;
    private int priority;
    
    public OrderStock (int n,int b, int d, String l, int p)
    {
        this.listNumber = n;
        this.base = b;
        this.destination = d;
        this.load = l;
        this.priority= p;
    }

    @Override
    public String toString()
    {
        return priority + " " + load + " " + destination;
    }

    public int getListNumber()
    {
        return this.listNumber;       
    }
    public void setListNumber(int n)
    {
        this.listNumber= n;
    }
    public int getBase()
    {
        return this.base;
    }
    public void setBase(int b)
    {
        this.base = b;
    }
    public int getDestination()
    {
        return this.destination;
    }
    public void setDestination(int d)
    {
        this.destination = d;
    }
    public String getLoad()
    {
        return this.load;
    }
    public void setLoad(String s)
    {
        this.load= s;
    }
    public int getPriority()
    {
        return this.priority;
    }
    public void setPriority(int p)
    {
        this.priority = p;
    }
    public int compareTo(OrderStock o)
    {
        if(this.priority < o.getPriority())
            return -1;
        else if(this.priority == o.getPriority())
            return 0;
        else 
            return 1;
        
    }
    
}
