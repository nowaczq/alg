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
public class OrderHeap {
    OrderStock []tab;
    int size;
    public OrderHeap()
    {
        tab = new OrderStock[1000];
        size = 0;
    }
    public void heapUp()
    {
        int i = size-1;
        for(int p = 0; p < size; p++)
        {
            if(this.tab[p].getPriority() < this.tab[i].getPriority())
            {
                swap(p,i);
            }
        }
    }
    public OrderStock []getTab()
    {
        return this.tab;
    }
    private void swap(int m, int n)
    {
        OrderStock assist = this.tab[m];
        this.tab[m] = this.tab[n];
        this.tab[n] = assist;
    }

    public void insert(OrderStock o)
    {
        tab[size++] = o;
        heapUp();
        
    }
    
    public OrderStock pop()
    {
        //zdjęcie najwyższej dostępnej paczki
        return this.tab[size];
    }
    
    public OrderStock getPackageByNumber(int num)
    {
        //pobranie paczki zgodnie z przekazanym numerem
        
        return this.tab[num];
    }
    
    public void heapPrinter()
    {
        //heapSort();
        for (int i=0;i<size;i++) {
            System.out.println(tab[i]);
        }
    }
}
