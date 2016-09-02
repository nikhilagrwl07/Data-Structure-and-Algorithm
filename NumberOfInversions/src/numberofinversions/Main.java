/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package numberofinversions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author nikhil.agrawal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
       ArrayList<Integer> a = new ArrayList<Integer>();
       
       a.add(1);
       a.add(2);
       a.add(3);
        
       int sum =4;
       
       System.out.println(coinchange2(a, sum));
        
    }
    
    
     public static int coinchange2(ArrayList<Integer> coins, int sum) {
         if(sum ==0 ) 
             return 1;
         
         if(coins.size()<=0) return 0;
         
        int[] ways = new int[sum+1];
        
        for(int i=0;i<ways.length;i++)
            ways[i]=0;
        
        
        ways[0]=1;
        
         for(int i=0; i<coins.size(); i++)
         {
             for(int j=coins.get(i); j<=sum; j++)
             {
                  ways[j] += ways[j-coins.get(i)];
             }
         }
           
        
//        for(int i=1;i<=sum;i++)
//        {
//            int max = 0;
//            
//            for(int coin : coins)
//            {   
//                if(i-coin==0)
//                {
//                    max =1 ;
//                }
//                else if((i-coin)>0 && ways[i-coin] > max)
//                {
//                    max=ways[i-coin];
//                }
//            }
//            if(max!=0)
//            {
//                ways[i]= max+1;
//            }
//            else
//            {
//                ways[i]= max;
//            }
//            
//            
//        }
        return ways[sum];
    }
     
     
     
     
}