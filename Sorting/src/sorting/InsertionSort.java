/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sorting;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nikhil.agrawal
 */
public class InsertionSort {
     public static void main(String[] args) {
     
//         int[] list = {14, 32, 67, 76, 23, 41, 58, 85,-1,-1,32};
         List<Integer> list =Arrays.asList(14, 32, 67, 76, 23, 41, 58, 85,-1,-1,32);
         
          
        System.out.println("before:\n " +list);  
        insertionSort(list, 0, list.size()-1);
        System.out.println("After:\n " +list);  
         
    }
     
    public static void insertionSort(List<Integer> a,int start,int end)
    {
        int i,j,temp,val,check =-1,k;
       
        for(i=start;i<=end;i++)
        {
            j=start;
            
            while(j<i)
            {
                if(a.get(j)>a.get(i))
                {
                    check=1;
                    break;
                }
            j++;
                
            }
            
            val=a.get(i);
            temp=j;
            k=i-1;
            while(j<=k && check==1)
            {
                a.set(k+1, a.get(k)); 
                k--;
            }
             a.set(temp,val); 
        // System.out.println("i = "+ i+" "+ Arrays.toString(a));
        }
      }
  

}
