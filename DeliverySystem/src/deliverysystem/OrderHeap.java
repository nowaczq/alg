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
//        for(int i=0;i<10;i++)
//            tab[i] = new OrderStock(0,0,0,"",0);
        size = 0;
    }
    public void heapUp()
    {
        int i = size-1;
      //  int p = size/2;
//        System.out.println("przed petla while: ");
//        heapPrinter();
//        while(i>0 && this.tab[p].getPriority() <= this.tab[i].getPriority())
//        {
//            System.out.println("petla while: " + i + " " + p);
//            swap(p,i);
//            i = p;
//            p=(i-1)/2;
//        }
//        System.out.println("po petla while: ");
//        heapPrinter();
        for(int p = 0; p < size; p++)
        {
            if(this.tab[p].getPriority() < this.tab[i].getPriority())
            {
                swap(p,i);
            }
        }
    }
    private void swap(int m, int n)
    {
        OrderStock assist = this.tab[m];
        this.tab[m] = this.tab[n];
        this.tab[n] = assist;
    }
//    public OrderStock pop()
//    {
//        int n = this.tab.length;
//        OrderStock tmp = this.tab[0];
//        this.tab[0] = this.tab[--n];
//        heapDown();
//        return tmp;
//    }
//    public void heapDown()
//    {
//        int i = 0;
//        int c = 2*i + 1;
//        while(c < this.tab.length)
//        {
//            if(c+1 < this.tab.length && this.tab[c+1].getPriority() > this.tab[c].getPriority())
//                c++;
//            if(this.tab[c].getPriority() <= this.tab[i].getPriority())
//                return;
//            swap(this.tab,i,c);
//            i=c;
//            c=2*i+1;
//        }
//    }
//    public void heapSort()
//    {
//        for(int i=1;i<this.tab.length;i++)
//            heapUp();
//        for(int i = 0; i >0;i--)
//        {
//            swap(this.tab,0,i);
//            heapDown();
//        }
//    }
    public void insert(OrderStock o)
    {
        tab[size++] = o;
        heapUp();
        
    }
    public void heapPrinter()
    {
        //heapSort();
        for (int i=0;i<20;i++) {
            System.out.println(tab[i]);
        }
    }
}
