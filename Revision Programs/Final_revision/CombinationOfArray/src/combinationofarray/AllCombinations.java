
package combinationofarray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author nikhil.agrawal
 */
public class AllCombinations {

//    static char[] B = {'A', 'B', 'C', 'D'};
   // static char[] B = {'1' , '0'};
    
    static int count = 3;
    
    public static void main(String[] args) {
       
        
       int[] a = new int[count];
       
       combination(a, 0, count-1);
       
    }
    
    public static void combination(int[] a , int k , int N){

//        System.out.println("k =" + k + " N = " + N);
        if(k>N) 
            return;
        
        if( k==N)
        {
            a[k]=0;
            printArray(a,N);
            a[k]=1;
            printArray(a,N);
        }
        
        a[k]=0;
        combination(a, k+1, N);
        a[k]=1;
        combination(a, k+1, N);
        
    }
    
    public static void printArray(int[] a,int n)
    {
        int sum =0;

//        
//        ArrayList<Character> arrayList = new ArrayList<Character>();
//        
//        for(int i=0;i<a.length;i++)
//        {
//            
//            if(a[i]==1)
//            {
//                sum++;
//                arrayList.add(B[i]);
//            }
//            
//        }
//        
//        if(sum == count)
//        {
//            for(Character c : arrayList){
//                System.out.print(c);
//            }
//            System.out.println("");
//        }
        
//        boolean flag = true;
        
        for(int i=1;i<=n;i++)
        {
         if(a[i-1]==1 && a[i]==1)
             return;
        }
        
        System.out.println("" + Arrays.toString(a));
        
        System.out.println("");
            
    }

}
