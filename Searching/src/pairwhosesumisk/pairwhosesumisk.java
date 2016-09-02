/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pairwhosesumisk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author nikhil.agrawal
 */
public class pairwhosesumisk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       int[] a = { 2, 4, 7, 5, 9, 10, -1};
//       int[] a = { 0,0,0,0,0,0,0,0,0,0,0};
//         int[] a = { 0};
        int a[]= {1,2,8,6,3,4,5,0,4,4,3,6,5,3,5};
        
       findingPairs(a, 8);
    }
    
    
    public static void findingPairs(int a[] , int x)
    {
        
        if(a==null) return;
        if(a.length==1) return;
        
       Arrays.sort(a);
       
      Set<Pair<Integer, Integer>> map  = new HashSet();
       
        int low=0,high=a.length-1;
        
        while(low<high)
        {
            if(a[low]+a[high]<x)
            {
                low++;
            }
            else if(a[low]+a[high]>x)
            {
                high--;
            }
            else {
//                System.out.println("check 1");
                Pair<Integer, Integer> pair1 = new Pair<Integer, Integer>();
                pair1.First=a[low];
                pair1.Second=a[high];
                if(!map.contains(pair1))
                {
                   System.out.println(a[low] + ":: " + a[high]);
                   map.add(pair1);  
                }
                low++;
                high--;
            }
        }
    }
    
    
    
    

}
class Pair<T, U>{
    T First;
    U Second;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if(First !=null)
        {
            if(!First.equals(pair.First))
            {
                return false;
            }
            
            if(Second ==null) return false;
            
            if(!Second.equals(pair.Second))
                return false;
                    
            return true;        
            
        }
        return false;
     
    }
    
    
//
    @Override
    public int hashCode() {
//        System.out.println(First + " First.hashCode() :: " + First.hashCode());
        
//        System.out.println(Second + " Second.hashCode() :: " + Second.hashCode());
        
        
        int result = First != null ? First.hashCode() : 0;

        result = 31* result + (Second != null ? Second.hashCode() : 0);
        return result;
    }
}


