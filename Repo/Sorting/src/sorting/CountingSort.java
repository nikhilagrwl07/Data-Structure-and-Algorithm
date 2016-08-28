
package sorting;

import java.util.Arrays;

public class CountingSort {

  
    public static void main(String[] args) {
        int input[]={51,7,3,6,3,9,9,9,9,9,1,1,1,1,5,5,5,50,2,2,2,2,4,4,4,4,7,7,7,34,5,27,12,77,23,78,65,34,71,45};
        int output[]=new int[input.length];
        int k=100;

       printout(input,input.length,"Input String");

//     countingSort(input,output,k);
//     
////
//     printout(output,output.length,"Sorted Input Sequence");

     // sorting input in input range M to N
     int m=1,n=10;
     int b1[]=new int[input.length];

     countingSortWithinRange(input,b1,m,n);

      printout(b1,b1.length,"Sorted Input Sequence Within range");
    }
    
    public static void printout(int a[],int r,String s)
    {
        System.out.println(s);
        for(int i=0;i<r;i++)
        {
            
         //   long currentTimeMillis = System.currentTimeMillis();
            System.out.print(a[i]+" ") ; //+"  "+System.currentTimeMillis());
        }
        
        System.out.println();
    }
    public static void countingSort(int input[],int output[],int range)
    {
        int n=input.length;
        
        int freq[]=new int[range];
        int i,j;
        
        // intinializing C[range] i.e., type array
        for(i=0;i<range;i++)
            freq[i]=0;
       // incremeneting the frequcency by 1  
        for(j=0;j<n;j++)
            freq[input[j]]=freq[input[j]]+1;    // Counting Sort is only possible for positive number.
        
        // Now calculating the cumulative frequency    
        for(i=1;i<range;i++)
            freq[i]=freq[i]+freq[i-1];
        
          //System.out.println();
        ///for(j=n-1;j>=0;j--)
        for(j=0;j<n;j++)
        {
//            System.out.println(":: " + freq[input[j]]);
            freq[input[j]]--;
            output[freq[input[j]]]=input[j];
            
         //   freq[input[j]]=freq[input[j]]-1;
        }
        
    }
 
    public static void countingSortWithinRange(int a[],int b1[],int m,int n)
    {
        int c[]=new int[n-m+1];
        int i=0;
        
        // intintializing the value to 0
        for(i=0;i<c.length;i++)
            c[i]=0;
        
        // counting the frequency of each element
        for(i=0;i<a.length;i++)
        {
            if(m<=a[i] && a[i]<=n)
            {
                c[a[i]-m]=c[a[i]-m]+1;
            }
        }
        
        // calculating the cumulative frequency
        for(i=1;i<c.length;i++)
            c[i]=c[i]+c[i-1];
        
        
        // finally placing the sorted array in output
        
         for(i=0;i<a.length;i++)
        {
            if(m<=a[i] && a[i]<=n)
            {
              //  System.out.println("V = "+freq[input[i]]);
                b1[--c[a[i]-m]]=a[i];
            }
            
        }
        
    }


}
