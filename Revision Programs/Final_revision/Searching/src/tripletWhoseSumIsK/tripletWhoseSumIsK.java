/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tripletWhoseSumIsK;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author nikhil.agrawal
 */
public class tripletWhoseSumIsK {
    
    public static void main(String[] args) {
//        int[] a = { 1,1, 4,4, 45, 6, 10, 8,8 };
//        int[] a = { 0,0,0,0,0,0,0,0,0,0,0};
        int a[] = {-1 ,0 ,1 ,2 ,-1, -4};
        
        int sum = 0;
        findTriplets(a, sum);
        
    }
    
    
    public static void findTriplets(int a[], int p)
    {
        
        if(a==null || a.length==1) return;
        
        Arrays.sort(a);
        
        Set<Triplet> triplet= new HashSet<Triplet>();
        
        for(int i=0;i<=a.length-3;i++)
        {
            
            int low = i+1;
            int high = a.length-1;
            
            while(low<high)
            {
//                System.out.println(" i = " + i +  " l = "+ low + " " + " h = "+ high);
                
                int sum = a[low]+a[high] + a[i];
                
                if(sum==p)
                {
                   
                    Triplet t = new Triplet();
                    t.First=a[i];
                    t.Second=a[low];
                    t.Third=a[high];
                    
                    if(!triplet.contains(t))
                    {
                         System.out.println(a[i] + " "+a[low] + " "+ a[high]);
                         triplet.add(t);
                         
                    }
                    low++;
                     high--;
                }
                else if(sum<p)
                {
                    low++;
                }
                else
                {
                    high--;
                }
                    
            }
        }
    }
    


}



class Triplet<T, U , X>{
    T First;
    U Second;
    X Third;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Triplet<?, ? , ?> pair = (Triplet<?, ? , ?>) o;

        if(First !=null)
        {
            if(!First.equals(pair.First))
            {
                return false;
            }
            
            if(Second ==null || !Second.equals(pair.Second) ) return false;
            
            if(Third ==null || !Third.equals(pair.Third) ) return false;      
            
            return true;
            
        }
        return false;
     
    }
     @Override
    public int hashCode() {
        int result = First != null ? First.hashCode() : 0;
        result = 31 * result + (Second != null ? Second.hashCode() : 0);
        return result;
    }
}
    