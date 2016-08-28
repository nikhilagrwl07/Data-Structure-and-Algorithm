/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3sum;

import java.util.*;


public class Main {
    public static void main(String args[])
    {
    int a[]={12, 3, 4, 1, 6, 9};
    int sum=24;
    
    findtriplet(a,sum);
    }
    
    public static void findtriplet(int array[],int s)
    {        
        HashMap<Integer, Integer[]> sumPairs = new HashMap<>();
    // compute all sum pairs
    for(int n1 : array)
        for(int n2 : array)
           if (!sumPairs.containsKey(n2+n1))    //   contains(n1 + n2)) 
               sumPairs.put(n1 + n2, new Integer[] {n1, n2});

    for(int n1 : array)
        if (sumPairs.containsKey(s-n1))
        {
            for (int pair : sumPairs.get(s-n1))
            {
                System.out.println(pair + "* ");
              //  System.out.println();
            }
            System.out.println(n1);
             System.out.println("----------------------");
        }
    
        // creating hashMap and putting all possible two element submation pair
         /*  Map<Integer,Integer[]> hm=new HashMap<Integer,Integer[]>();
           
           
           
           
           for(i=0;i<a.length;i++)
           {
               for(j=i;j<a.length;j++)
               {
                     hm.put(a[i]+a[j], new Integer[] {i,j});
               }
           }
           
           // Now checking c=-(a+b) is possible or NOT
           for(i=0;i<a.length;i++)
           {
               int t=s-a[i];
               
               if(hm.containsKey(t))//      contains(t))
               {
                   System.out.println("Sum= "+s+" exists.\n Values are:");
                 System.out.println(a[i]);
                  System.out.println(hm.get(t));
                    System.out.println("------------------");
               }
               
            //   System.out.println("Sum= "+s+" exists.");
           }*/
    }
}


