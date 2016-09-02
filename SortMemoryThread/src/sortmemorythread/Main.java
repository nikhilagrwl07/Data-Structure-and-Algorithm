/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sortmemorythread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author nikhil.agrawal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Thread arr[] = { new Thread(1, 512, 1, 'R'), 
                        new Thread(2, 432, 2, 'W'),
                        new Thread(3, 512, 3, 'R'), 
                     new Thread(4, 932, 4, 'R'),
                     new Thread(5, 512, 5, 'W'), 
                    new Thread(6, 932, 6, 'R'),
                     new Thread(7, 835, 7, 'R'), 
                    new Thread(8, 432, 8, 'R')
                   };
        
        List<Thread> al = new ArrayList<Thread>();
        al.addAll(Arrays.asList(arr));
        sort(al);
    }
    
    public static void sort(List<Thread> arr)
    {
        if(arr==null  || arr.size()==0 || arr.size() ==1) return;
        
        Collections.sort(arr, Thread.memoryBlock);
        
        for(int i=1;i<arr.size();i++)
        {
            Thread current=arr.get(i);
            Thread previous = arr.get(i-1);
            if(current.getMemblock()==previous.getMemblock())
            {
                
                if(current.getTime() <= previous.getTime()+5)
                {
                    int j=i-1;
                    while(current.getMemblock()== arr.get(j).getMemblock()
                            && current.getTime()<=(arr.get(j).getTime()+5)
                             && j>=0)
                    {
                        if(current.getAccess()== 'W' || arr.get(j).getAccess()=='W')
                        {
                            System.out.println("Threads "+ current.getId() + " and " + arr.get(j).getId() 
                                    +" are conflicting ...");
                        }
                        j--;
                    }
                    
                }
            }
        }
        System.out.println("All thread all completed ..");
    }
    
    

}
