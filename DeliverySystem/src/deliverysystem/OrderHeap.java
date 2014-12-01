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
    OrderStock<OrderStock> []t;
    private int index =0;
    public OrderHeap(int n)
    {
        t= (OrderStock[]) new Object[n];
    }
    public void heapUp(OrderStock<OrderStock> []tab)
    {
        int i = tab.length;
        int p = (tab.length -1)/2;
        while(i>0 && tab[p].getPriority()<(tab[i].getPriority()))
        {
            swap(tab,p,i);
            i = p;
            p = (i-1)/2;
        }
    }

    private void swap(OrderStock<OrderStock> []tab, int i, int p)
    {
        OrderStock pom = tab[i];
        tab[i] = tab[p];
        tab[p] = pom;
    }
    public void insert(OrderStock tB)
    {
        t[index++] =tB;
        heapUp(this.t);
    }

    public OrderStock pop()
    {
        return t[--index];
    }
}
